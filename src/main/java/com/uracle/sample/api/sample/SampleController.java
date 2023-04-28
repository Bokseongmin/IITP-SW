package com.uracle.sample.api.sample;

import com.uracle.sample.support.MspUtil;
import com.uracle.sample.support.annotation.MSP;
import com.uracle.sample.support.result.MspResult;
import com.uracle.sample.support.result.MspStatus;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@MSP
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    //    @PostMapping("")
//    public HashMap<String, String> insertSample(@RequestBody Sample param) {
//        int affectRow = sampleService.insertSample(param);
//
//        HashMap<String, String> ret = new HashMap<>();
//        ret.put("affectRow", String.valueOf(affectRow));
//
//        return ret;
//    }
    @PostMapping("")
    public ResponseEntity<MspResult> insertSample(@RequestBody Sample param) {
        MspResult result;
        int affectRow = sampleService.insertSample(param);

        if(affectRow > 0) {
            //정상일 때
            result = MspUtil.makeResult(MspStatus.OK, param);
        } else {
            result = MspUtil.makeResult("9999", "이미 등록되어 있습니다.", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<MspResult> getSamples() {
        MspResult result;

        List<Sample> body = sampleService.selectSamples();
        int bodySize = body.size();

        if(bodySize > 0) {
            result = MspUtil.makeResult(MspStatus.OK, body);
        } else {
            result = MspUtil.makeResult("8888", "등록된 사용자가 아닙니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MspResult> getSampleById(@PathVariable("id") String id) {
        MspResult result;

        Sample param = new Sample();
        param.setId(id);
        Sample body = sampleService.selectSampleById(param);

        if(body != null) {
            result = MspUtil.makeResult(MspStatus.OK, body);
        } else {
            result = MspUtil.makeResult("8888", "등록된 사용자가 없습니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<MspResult> upSample(@PathVariable("id") String id, @RequestBody Sample param) {
        MspResult result;

        param.setId(id);
        int affectRow = sampleService.updateSample(param);

        if(affectRow > 0) {
            result = MspUtil.makeResult(MspStatus.OK, param);
        } else {
            result = MspUtil.makeResult("4444", "수정할 사용자가 없습니다.", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MspResult> delSampleById(@PathVariable("id") String id) {
        MspResult result;

        Sample param = new Sample();
        param.setId(id);

        int affectRow = sampleService.delectSample(param);

        if(affectRow > 0 ) {
            result = MspUtil.makeResult(MspStatus.OK, param);
        } else {
            result = MspUtil.makeResult("4444", "삭제할 사용자가 없습니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
