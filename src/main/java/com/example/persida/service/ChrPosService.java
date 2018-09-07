package com.example.persida.service;

import com.example.persida.model.ChrPos;
import com.example.persida.model.ChrPosId;
import com.example.persida.model.Gen;
import com.example.persida.model.GenId;
import com.example.persida.repository.ChrPosRepository;
import com.example.persida.repository.GenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class ChrPosService {

    @Autowired
    public ChrPosRepository chrPosRepository;


    @Autowired
    public GenRepository genRepository;

    public void uploadVariantFile(MultipartFile file) {

        ChrPosId chrPosId;
        ChrPos chrPos;

        try{
            Scanner scanner = new Scanner(this.convert(file));
            while (scanner.hasNext()) {
                String[] columns = scanner.nextLine().split(",");
                chrPosId = new ChrPosId(columns[0].trim(), Long.parseLong(columns[1].trim()));
                chrPos = new ChrPos(chrPosId, columns[2].trim(), columns[3].trim(), columns[4].trim());
                chrPosRepository.save(chrPos);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void uploadGeneFile(MultipartFile file) {

        GenId genId;
        Gen gen;


        try{
            Scanner scanner = new Scanner(this.convert(file));
            while (scanner.hasNext()) {
                String[] columns = scanner.nextLine().split(",");
                genId = new GenId(columns[0].trim(), Long.parseLong(columns[1].trim()));
                gen = new Gen(genId, Long.parseLong(columns[2].trim()), columns[3].trim());
                genRepository.save(gen);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public ChrPos getChrAndPos(String chr, Long pos) {
        ChrPosId chrPosId = new ChrPosId(chr, pos);
        return chrPosRepository.findByChrPosId(chrPosId);
    }

    public List<ChrPos> getChr(String chr) {
        return chrPosRepository.findByChrPosIdChr(chr);
    }

    public List<ChrPos> getBetweenPos(Long pos1, Long pos2) {
        return chrPosRepository.getBetweenPos(pos1, pos2);
    }

    public List<ChrPos> getDeletion() {
        return chrPosRepository.getDeletion();
    }


    public List<ChrPos> getVariant(String gen){
        return chrPosRepository.getVariant(gen);
    }
}
