package edu.gzu.lms.dao;

import edu.gzu.lms.entity.Reader;

import java.util.List;

public interface ReaderDAO {
    /**
     * 获取全部读者
     * @return
     */
    List<Reader> getAllReader(int page, int limit);

    /**
     * 通过id查询用户
     * @param name
     * @return
     */
    Reader getReaderByName(String name);

    /**
     * 删除读者通过id
     * @param id
     * @return
     */
    int deleteReaderById(String id);

    /**
     * 添加读者
     * @param reader
     * @return
     */
    int insertReader(Reader reader);

    /**
     * 更新读者信息
     * @param reader
     * @return
     */
    int updateReader(Reader reader);

    /**
     * 获取读者数量
     * @return
     */
    Long countReader();
}
