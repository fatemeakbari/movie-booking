package com.example.moviebooking.service.place;

import com.example.moviebooking.entity.place.Place;
import com.example.moviebooking.entity.place.PlaceComment;
import com.example.moviebooking.entity.place.PlaceRate;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.repository.place.PlaceRepository;
import com.example.moviebooking.service.RateService;
import com.example.moviebooking.service.UtilService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;


@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Qualifier("placeRateService")
    @Autowired
    private RateService rateService;

    @Autowired
    private UtilService utilService;

    @Autowired
    private Environment env;

    public Place save(Place place){
        try{
            return placeRepository.save(place);
        }
        catch (Exception ex){
            throw new IllegalArgumentException("Please Enter valid data");
        }
    }

    public Place update(Long id, Place place){
        place.setId(id);
        return placeRepository.save(place);
    }

    public Place findById(Long id){
        try{
            Place place = placeRepository.findById(id).get();
            float rate =  rateService.findAverageByForeignId(place.getId());
            place.setRate(rate);
            return place;
        }
        catch (Exception ex){
            throw new EntityNotFoundException("place not found  with id: "+id);
        }
    }

    public Page<Place> findAll(Pageable pageable){
        return placeRepository.findAll(pageable);
    }

    public Place findByName(String name){
        return placeRepository.findByNameLike(name);
    }

    public List<Place> findAllByOrderByRate(){
        //return placeRepository.findAllByOrderByRate();
        return null;
    }

    public Float ratedAndFindNewRate(Long id, Long userId, Integer rate){
        PlaceRate placeRate = new PlaceRate();
        placeRate.setPlace(new Place(id));
        placeRate.setUser(new User(userId));
        placeRate.setRate(rate);
        rateService.save(placeRate);
        return rateService.findAverageByForeignId(placeRate.getPlace().getId());
    }


    public void deleteById(Long id){
        try{
            placeRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("foreign key constraint occure : "+id);
        }
        catch (EmptyResultDataAccessException ex){
            throw new IllegalArgumentException("place not found with id: "+id);
        }
    }

    public void uploadImagesById(Long id, MultipartFile indexImage) {
        findById(id);

        String extension;
        String root = env.getProperty("file.place.upload-image");
        String uploadImagePath = Paths.get(root, id.toString()).toString();

        File dir = new File(uploadImagePath);
        utilService.createDir(dir);

        extension = FilenameUtils.getExtension(indexImage.getOriginalFilename());
        String indexImageSavedPath = Paths.get(dir.getPath(),id+"_index."+extension).toString();
        utilService.saveFile(indexImageSavedPath, indexImage);

    }

    public void deleteUploadedImagesById(Long id){
        findById(id);
        String root = env.getProperty("file.place.upload-image");
        String uploadImagePath = Paths.get(root, id.toString()).toString();
        utilService.deleteDirectoryOfUploadedFile(uploadImagePath);
    }


}
