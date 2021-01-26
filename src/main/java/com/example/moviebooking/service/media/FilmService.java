package com.example.moviebooking.service.media;

import com.example.moviebooking.entity.media.MediaComment;
import com.example.moviebooking.repository.PerformanceRepository;
import com.example.moviebooking.entity.media.Film;
import com.example.moviebooking.entity.media.Media;
import com.example.moviebooking.entity.media.MediaRate;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.repository.media.FilmRepository;
import com.example.moviebooking.service.CommentService;
import com.example.moviebooking.service.RateService;
import com.example.moviebooking.service.UtilService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    UtilService utilService;


    @Autowired
    private RateService rateService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Environment env;

    @Autowired
    private PerformanceRepository performanceRepository;


    public Film save(Film film){
        film.setTehranTotalSale(0d);
        film.setTownshipTotalSale(0d);
        try{
            return filmRepository.save(film);
        }
        catch (DataIntegrityViolationException ex){
            if(ex.getMessage().contains("unique_name")){
                throw new DataIntegrityViolationException("The name of film must be unique");
            }
            throw new DataIntegrityViolationException("Please insert valid information "+ex.getMessage());
        }
    }

    public Film update(Long id, Film film){
        if (findById(id) != null) {
          film.setId(id);
          return filmRepository.save(film);
        }
        return null;
    }

    public Page<Film> findAllByOrderByProductionDate(Pageable pageable){
        return filmRepository.findAllByOrderByProductionDate(pageable);
    }


    public Film findById(Long id){
        try{
            Film film = filmRepository.findById(id).get();
            float rate = rateService.findAverageByForeignId(film.getId());
            film.setRate(rate);
            return film;
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Not Found film with id: "+id);
        }
    }

    public Page<Film> findAllByReleasesTrue(Pageable pageable){
        return filmRepository.findAllByReleasedTrue(pageable);
    }

    public Page<Film> findAllByReleasedFalseOrderByProductionDate(Pageable pageable){
        return filmRepository.findAllByReleasedFalseOrderByProductionDate(pageable);
    }

    public List<Film> findByNameLike(String name){
        return filmRepository.findByNameLike(name);
    }


    public Float ratedAndFindNewRate(Long id, Long userId, Integer rate){
        MediaRate mediaRate=  new MediaRate();
        mediaRate.setMedia(new Media(id));
        mediaRate.setUser(new User(userId));
        mediaRate.setRate(rate);
        rateService.save(mediaRate);
        return rateService.findAverageByForeignId(mediaRate.getMedia().getId());
    }

//    public void addCommentById(Long id, MediaComment comment){
//
//        Media media = new Media(id);
//        comment.setMedia(media);
//        commentService.save(comment);
//    }
//
//    public void likeCommentByCommentId(Long commentId){
//        commentService.likeById(commentId);
//    }
//
//    public Page<MediaComment> findCommentById(Pageable pageable, Long id){
//        return commentService.findByForeignId(pageable, id);
//    }

    public void deleteById(Long id){

        try{
            filmRepository.deleteById(id);
            deleteUploadedImagesById(id);
            deleteUploadedTrailerById(id);
        }
        catch (Exception ex){
            throw new IllegalArgumentException("The film with id: "+id+" not exist!");
        }
    }



    public void uploadImagesById(Long id, MultipartFile indexImage,
                             MultipartFile[] images) {

        if(indexImage == null){
            throw new IllegalArgumentException("The index image must not be null!");
        }
        findById(id);

        String extension;
        String root = env.getProperty("file.media.upload-image");
        String uploadImagePath = Paths.get(root, id.toString()).toString();

        File dir = new File(uploadImagePath);
        if(!utilService.createDir(dir)){
            deleteUploadedImagesById(id);
            utilService.createDir(dir);
        }

        extension = FilenameUtils.getExtension(indexImage.getOriginalFilename());
        String indexImageSavedPath = Paths.get(dir.getPath(),id+"_index."+extension).toString();
        utilService.saveFile(indexImageSavedPath, indexImage);

        for (int i = 0; i < images.length; i++) {
            extension = FilenameUtils.getExtension(images[i].getOriginalFilename());
            String name = id + "_" + i+"."+extension;
            String imageSavedPath = Paths.get(dir.getPath(),name).toString();
            utilService.saveFile(imageSavedPath, images[i]);
        }
    }

    public void deleteUploadedImagesById(Long id){
        //findById(id);
        String root = env.getProperty("file.media.upload-image");
        String uploadImagePath = Paths.get(root, id.toString()).toString();
        utilService.deleteDirectoryOfUploadedFile(uploadImagePath);
    }


    public void uploadTrailerById(Long id, MultipartFile trailer) {
        if(trailer == null){
            throw new IllegalArgumentException("The trailer file must not be null!");
        }
        findById(id);
        String extension = FilenameUtils.getExtension(trailer.getOriginalFilename());
        String root = env.getProperty("file.media.upload-trailer");
        String uploadedTrailerPath = Paths.get(root,id.toString()).toString();
        File dir = new File(uploadedTrailerPath);
        if(!utilService.createDir(dir)){
            deleteUploadedTrailerById(id);
            utilService.createDir(dir);
        }
        String trailerSavedPath = Paths.get(dir.getPath(), id+"_trailer."+extension).toString();
        utilService.saveFile(trailerSavedPath, trailer);
    }

    public void deleteUploadedTrailerById(Long id) {
        //findById(id);
        String root = env.getProperty("file.media.upload-trailer");
        String uploadedTrailerPath = Paths.get(root,id.toString()).toString();
        utilService.deleteDirectoryOfUploadedFile(uploadedTrailerPath);

    }


}
