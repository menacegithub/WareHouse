package org.example.extratomeee.controller;

import org.example.extratomeee.dto.AttachmentDto;
import org.example.extratomeee.model.Attachment;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @GetMapping
    public List<Attachment> getAll() {
        List<Attachment> attachmentList = attachmentService.getAttachments();
        return attachmentList;
    }
    @GetMapping
    public Attachment getById(@PathVariable Integer id) {
        Attachment attachmentById = attachmentService.getAttachmentById(id);
        return attachmentById;
    }
    @PostMapping
    public Result add(@RequestBody AttachmentDto attachmentDto) {
        Result attachment = attachmentService.createAttachment(attachmentDto);
        return attachment;
    }
    @PutMapping
    public Result update(@PathVariable Integer id,@RequestBody AttachmentDto attachmentDto) {
        Result updated = attachmentService.updateAttachment(id, attachmentDto);
        return updated;
    }
    @DeleteMapping
    public Result delete(@PathVariable Integer id) {
        Result deleted = attachmentService.deleteAttachment(id);
        return deleted;
    }

}
