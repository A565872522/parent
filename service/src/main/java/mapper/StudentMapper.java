package mapper;

import entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student getInfo();

    int insert(Student record);

    int insertSelective(Student record);
}