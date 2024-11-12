package kdt.fullstack.project.dao;

import org.apache.ibatis.annotations.Mapper;

import kdt.fullstack.project.domain.DetailDTO;
import kdt.fullstack.project.domain.UserRequestDTO;

@Mapper
public interface UsersMapper {
    
    public UserRequestDTO loginRow(UserRequestDTO params);

    public void registerRow(UserRequestDTO prarms);

    public String checkRow(UserRequestDTO prarms);

    public void likeRow(DetailDTO params);

}
