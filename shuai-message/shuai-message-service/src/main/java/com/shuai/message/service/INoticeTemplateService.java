package com.shuai.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuai.common.domain.dto.PageDTO;
import com.shuai.message.domain.dto.NoticeTemplateDTO;
import com.shuai.message.domain.dto.NoticeTemplateFormDTO;
import com.shuai.message.domain.po.NoticeTemplate;
import com.shuai.message.domain.query.NoticeTemplatePageQuery;

/**
 * <p>
 * 通知模板 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-19
 */
public interface INoticeTemplateService extends IService<NoticeTemplate> {

    Long saveNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    void updateNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    PageDTO<NoticeTemplateDTO> queryNoticeTemplates(NoticeTemplatePageQuery pageQuery);

    NoticeTemplateDTO queryNoticeTemplate(Long id);

    NoticeTemplate queryByCode(String code);
}
