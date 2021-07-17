package com.demo.ql.service;

import com.demo.ql.annotation.Log;
import com.demo.ql.dao.TranscationDDao;
import com.demo.ql.dao.TranscationMDao;
import com.demo.ql.dao.TranscationTDao;
import com.demo.ql.domain.TranscationD;
import com.demo.ql.domain.TranscationM;
import com.demo.ql.domain.TranscationT;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TranscationServiceImpl implements TranscationService{

    @Resource
    private TranscationDDao transcationDDao;
    @Resource
    private TranscationMDao transcationMDao;
    @Resource
    private TranscationTDao transcationTDao;

    @Log
    @Override
    @Transactional
    public void insert() {
        TranscationM transcationM = new TranscationM()
                .setName("testy");
        TranscationD transcationD = new TranscationD()
                .setName("testd");

        transcationMDao.insert(transcationM);
        transcationDDao.insert(transcationD);
    }

    @Override
    public void insertT() {
        TranscationT transcationT = new TranscationT()
                .setName("testt");
        transcationTDao.insert(transcationT);
    }


}
