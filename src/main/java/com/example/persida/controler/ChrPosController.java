package com.example.persida.controler;

import com.example.persida.file.UploadFileResponse;
import com.example.persida.model.ChrPos;
import com.example.persida.service.ChrPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChrPosController {

    @Autowired
    public ChrPosService chrPosService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploadFile/")
                .path(fileName)
                .toUriString();

        chrPosService.uploadFile(file);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/getchrandpos/{chr}/{pos}")
    public ChrPos getChrAndPos(@PathVariable("chr") String chr, @PathVariable("pos") Long pos) {
        return chrPosService.getChrAndPos(chr, pos);
    }

    @GetMapping("/getchr/{chr}")
    public List<ChrPos> getChr(@PathVariable("chr") String chr) {
        return chrPosService.getChr(chr);
    }

    @GetMapping("/getbetweenpos/{pos1}/{pos2}")
    public List<ChrPos> getBetweenPos(@PathVariable("pos1") Long pos1, @PathVariable("pos2") Long pos2) {
        return chrPosService.getBetweenPos(pos1, pos2);
    }

    @GetMapping("/deletion")
    public List<ChrPos> getDeletion() {
        return chrPosService.getDeletion();
    }

}
