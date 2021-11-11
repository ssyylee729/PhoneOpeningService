package com.example.mobilephoneopeningservice.domain.common;

import com.example.mobilephoneopeningservice.domain.Opening;
import com.example.mobilephoneopeningservice.domain.OpeningHistory;
import com.example.mobilephoneopeningservice.repository.OpeningHistoryRepository;
import com.example.mobilephoneopeningservice.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class OpeningEntityListener {
    @PostPersist
    @PostUpdate
    public void preUpdate(Object o){
        OpeningHistoryRepository openingHistoryRepository = BeanUtils.getBean(OpeningHistoryRepository.class);
        Opening opening = (Opening) o;

        OpeningHistory openingHistory = new OpeningHistory();
        openingHistory.setRequestDt(opening.getRequestDt());
        openingHistory.setStatus(opening.getStatus());
        openingHistory.setOpening(opening);
        openingHistoryRepository.save(openingHistory);

    }
}
