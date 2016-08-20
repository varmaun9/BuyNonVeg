/**
 *
 */
package com.meat.service;

import com.meat.domain.UserSearch;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IUserSearchService {
    UserSearch create(UserSearch userSearch);

    void deleteUserSearch(String userSearchId);

    List<UserSearch> getAll();

    UserSearch getUserSearch(String userSearchId);

    UserSearch updateUserSearch(UserSearch userSearch);

}
