package io.templend.service;

import io.templend.model.BorrowRequest;

public interface BorrowRequestService {

    void requestOrResponse(BorrowRequest borrowRequest) throws Exception;
}
