package com.yaas.recoderuserservice.client;

import com.yaas.recoderuserservice.model.CrMenteesResponseModel;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:30000", name = "codereview-service")
public interface CodeReviewService {
    @GetMapping({"/codereview/mentees"})
    // Map<String, Object> getCrMentees(@RequestParam Map<String, Long> paramMap);
    CrMenteesResponseModel getCrMentees(@RequestParam Map<String, Long> paramMap);
    //CrMenteesResponseModel getCrMentees(@RequestParam("menteeId") Long menteeId);
    
}
