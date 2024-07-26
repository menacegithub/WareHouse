package org.example.extratomeee.service;

import org.example.extratomeee.dto.AttachmentDto;
import org.example.extratomeee.model.Attachment;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<Attachment> getAttachments() {
        List<Attachment> attachmentList = attachmentRepository.findAll();
        return attachmentList;
    }
    public Attachment getAttachmentById(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            return optionalAttachment.get();
        }
        return null;
    }
    public Result createAttachment(AttachmentDto attachmentDto) {
        boolean existedByNameatt = attachmentRepository.existByNameatt(attachmentDto.getName());
        if (existedByNameatt) {
            return new Result(false, "Attachment already exists");
        }
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContentType(attachmentDto.getContentType());
        attachmentRepository.save(attachment);
        return new Result(true, "Attachment created");

    }
    public Result updateAttachment(Integer id, AttachmentDto attachmentDto) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
        }
        return new Result(false, "Attachment not found");
    }
    public Result deleteAttachment(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            attachmentRepository.delete(optionalAttachment.get());
            return new Result(true, "Attachment deleted");
        }
        return new Result(false, "Attachment not found");
    }

}
