package life.majiang.community.service;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuesstionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Quesstion;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuesstionMapper quesstionMapper;

    @Autowired
    private UserMapper userMapper;
    public PaginationDTO list(Integer page, Integer size) {
        Integer totalPage;
        PaginationDTO  paginationDTO = new PaginationDTO();
        Integer totalCount = quesstionMapper.count();
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        paginationDTO.setPagination(totalPage,page);
        if (page<1){
            page=1;
        }
        if (page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Quesstion> quesstions = quesstionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Quesstion quesstion:quesstions){
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        Integer totalPage;
        PaginationDTO  paginationDTO = new PaginationDTO();
        Integer totalCount = quesstionMapper.countByUserId(userId);
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        paginationDTO.setPagination(totalPage,page);
        if (page<1){
            page=1;
        }
        if (page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Quesstion> quesstions = quesstionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Quesstion quesstion:quesstions){
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Quesstion quesstion = quesstionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(quesstion,questionDTO);
       return  questionDTO;
    }
}
