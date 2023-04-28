package com.uracle.sample.api.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.xml.parsers.SAXParser;
import java.util.List;

@Service
@Slf4j
public class SampleService {
    @Autowired
    private SampleMapper sampleMapper;

    public int insertSample(Sample sample) {
//        int affectRow = sampleMapper.insertSample(sample);
//        // TODO: 사용자가 있는 지 SELECT
//        // 안 좋은 예시. >> Mapper에서 결정.
//        try {
//            affectRow = sampleMapper.insertSample(sample);
//        } catch (Exception e) {
//            log.error("중복 INSERT 에러 발생");
//            // DB쪽에서는 RuntimeException
//        }
        int affectRow = 0;

        try {
            affectRow = sampleMapper.insertSample(sample);
        } catch (DuplicateKeyException e) {

        }
        log.debug("INSERT affectRow: {}", affectRow);
        return affectRow;
    }

    public List<Sample> selectSamples() {
        List<Sample> samples = sampleMapper.selectSamples();

        log.debug("saples.size: {}", samples.size());
        for(Sample sample: samples) {
            log.debug(">>>> sample: {}", sample);
        }

        return samples;
    }

    public Sample selectSampleById(Sample param) {
        Sample sample = sampleMapper.selectSampleById(param);

//        if(sample==null) {
//            sample = new Sample();
//        }

        log.debug("sample: {}", sample);

        return sample;
    }

    public int updateSample(Sample sample) {
        int affectRow = sampleMapper.updateSample(sample);

        log.debug("UPDATE affectRow: {}", affectRow);
        return affectRow;
    }

    public int delectSample(Sample sample) {
        int affectRow = sampleMapper.deleteSample(sample);

        log.debug("DELETE affectRow: {}", affectRow);
        return affectRow;
    }
}
