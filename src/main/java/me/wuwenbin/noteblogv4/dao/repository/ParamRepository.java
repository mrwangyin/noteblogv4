package me.wuwenbin.noteblogv4.dao.repository;

import me.wuwenbin.noteblogv4.model.entity.NBParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * created by Wuwenbin on 2018/7/15 at 17:24
 *
 * @author wuwenbin
 */
@Transactional(rollbackOn = Exception.class)
public interface ParamRepository extends JpaRepository<NBParam, Long> {

    /**
     * 根据制定key查询对应的参数实体
     *
     * @param name
     * @return
     */
    NBParam findByName(String name);

    /**
     * 更新
     *
     * @param name
     * @param value
     */
    @Modifying
    @Query("update NBParam p set p.value = :value where p.name= :name")
    void updateInitParam(@Param("value") String value, @Param("name") String name);

}
