package io.templend.service;

import io.templend.model.BorrowRequestDetail;

import java.util.List;

public interface BorrowRequestDetailService {
    List<BorrowRequestDetail> getPendingByLender(String lender_id) throws Exception;

    List<BorrowRequestDetail> getByLendersItem(String lenderId, String itemId) throws Exception;

    List<BorrowRequestDetail> getByBorrower(String borrower_id) throws Exception;
}
