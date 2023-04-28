package com.uracle.sample.api.sample;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    Integer insertSample(Sample sample);
    List<Sample> selectSamples();
    Sample selectSampleById(Sample sample);
    Integer updateSample(Sample sample);
    Integer deleteSample(Sample sample);
}
