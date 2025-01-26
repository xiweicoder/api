import wechat from '@/../public/assets/WeChat.jpg';
import { GithubOutlined, WechatOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import '@umijs/max';
import { Tooltip } from 'antd';
import React from 'react';

const Footer: React.FC = () => {
  const defaultMessage = '西尾Ink';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      // @ts-ignore
      copyright={<>{`${currentYear} ${defaultMessage}`}</>}
      links={[
        {
          key: 'github',
          title: (
            <Tooltip title="查看本站技术及源码，欢迎 star">
              <GithubOutlined /> 支持项目
            </Tooltip>
          ),
          href: 'https://github.com/xiweicoder/api',
          blankTarget: true,
        },
        {
          key: 'contact',
          title: (
            <Tooltip title={<img src={wechat} alt="微信 code_nav" width="120" />}>
              <WechatOutlined /> 联系作者
            </Tooltip>
          ),
          href: 'https://lfs-api.oss-cn-beijing.aliyuncs.com/interface/WeChat.jpg',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
