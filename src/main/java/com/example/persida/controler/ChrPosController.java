package com.example.persida.controler;

import com.example.persida.file.UploadFileResponse;
import com.example.persida.model.ChrPos;
import com.example.persida.model.ChrPosId;
import com.example.persida.service.ChrPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/api")
public class ChrPosController {

    @Autowired
    public ChrPosService chrPosService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            String line = null;
            String[] fiedls = null;
            String[] pom = null;
            ChrPos chrPos;
            ChrPosId chrPosId;
            StringTokenizer st ;

            while ((line = reader.readLine()) != null) {

                st = new StringTokenizer(line,"\t");
                List<String> dataArray = new ArrayList<>() ;
                while(st.hasMoreElements()){
                    dataArray.add(st.nextElement().toString());
                }

                for (String item:dataArray) {
                    System.out.print(item + " *** ");
                }

                System.out.println(); // Print the data line.

//                fiedls = line.split("\\t");
//
//                for(String data: fiedls){
//                      System.out.println(data);
//                }

//                for(int i = 0; i <= fiedls.length; i++) {
//                    System.out.println(fiedls[i]);
//                }

//                chrPos = new ChrPos();
//                chrPosId = new ChrPosId();

//                chrPosId.setChr(fiedls[0]);
//                chrPosId.setPos(Long.parseLong(fiedls[1]));
//                chrPos.setChrPosId(chrPosId);
//                chrPos.setId(fiedls[2]);
//                chrPos.setRef(fiedls[3]);
//                chrPos.setAlt(fiedls[4]);

//                chrPosService.createChrPos(chrPos);

            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


}
