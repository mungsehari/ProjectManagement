package com.hari.service;

import com.hari.model.Issue;
import com.hari.model.User;
import com.hari.request.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {
    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssueByProjectId(Long projectId)throws Exception;

    Issue createIssue(IssueRequest issueRequest, User user) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;


    Issue addUserIssue(Long issueId, Long userId) throws Exception;

    Issue updateStatus(Long issueId,String status) throws Exception;

}
