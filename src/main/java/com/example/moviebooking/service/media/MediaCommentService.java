package com.example.moviebooking.service.media;

import com.example.moviebooking.entity.media.Media;
import com.example.moviebooking.entity.media.MediaComment;
import com.example.moviebooking.repository.media.MediaCommentRepository;
import com.example.moviebooking.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Primary
@Service
public class MediaCommentService implements CommentService<MediaComment> {

    @Autowired
    private MediaCommentRepository mediaCommentRepository;

    @Override
    public MediaComment save(Long mediaId, MediaComment mediaComment) {
        Media media = new Media();
        media.setId(mediaId);
        mediaComment.setMedia(media);
        mediaComment.setLike(0);
        try{
            return mediaCommentRepository.save(mediaComment);
        }
        catch (Exception ex){
            if(ex.getMessage().contains("fk_media_id")){
                throw new DataIntegrityViolationException("The media with id: "+media+" not exist!");
            }
            throw new IllegalArgumentException("Please inter valid information");
        }
    }

    @Override
    public Page<MediaComment> findByForeignId(Pageable pageable, Long mediaId) {
        return mediaCommentRepository.findByMediaId(pageable, mediaId);
    }

    @Override
    public void likeById(Long id) {
            mediaCommentRepository.likeById(id);
    }
}
