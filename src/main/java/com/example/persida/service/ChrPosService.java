package com.example.persida.service;

import com.example.persida.model.ChrPos;
import com.example.persida.repository.ChrPosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChrPosService {

    @Autowired
    public ChrPosRepository chrPosRepository;

    public ChrPos createChrPos(ChrPos chrPos) {
        return chrPosRepository.save(chrPos);
    }



}
