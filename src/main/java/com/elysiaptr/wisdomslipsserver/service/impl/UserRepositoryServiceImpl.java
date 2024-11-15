package com.elysiaptr.wisdomslipsserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elysiaptr.wisdomslipsserver.entity.UserRepository;
import com.elysiaptr.wisdomslipsserver.mapper.UserRepositoryMapper;
import com.elysiaptr.wisdomslipsserver.service.UserRepositoryService;
import org.springframework.stereotype.Service;

/**
* @author ElysiaPtr
 * @description 针对表【user_repository(用户仓库对应表)】的数据库操作Service实现
* @createDate 2024-11-13 21:11:53
*/
@Service
public class UserRepositoryServiceImpl extends ServiceImpl<UserRepositoryMapper, UserRepository>
    implements UserRepositoryService {

}




