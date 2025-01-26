import { PlusOutlined } from '@ant-design/icons';
import '@umijs/max';
import { Button } from 'antd';

export type SiderTheme = 'light' | 'dark';
export const Release = () => {
  return (
    <Button shape="round" key="1">
      <PlusOutlined /> 发布接口{' '}
    </Button>
  );
};
export const Docs = () => {
  return (
    <span
      className="anticon"
      style={{ fontSize: 14, fontWeight: 'bold' }}
      onClick={() => {
        window.open('https://github.com/xiweicoder/api', '_blank');
      }}
    >
      📘 开发者文档
    </span>
  );
};

export const helloWord = `
                                          _    _      _ _        __          __        _     _
                                         | |  | |    | | |       \\ \\        / /       | |   | |
                                         | |__| | ___| | | ___    \\ \\  /\\  / /__  _ __| | __| |
    |  __  |/ _ \\ | |/ _ \\    \\ \\/  \\/ / _ \\| '__| |/ _\` |
                                         | |  | |  __/ | | (_) |    \\  /\\  / (_) | |  | | (_| |
                                         |_|  |_|\\___|_|_|\\___/      \\/  \\/ \\___/|_|  |_|\\__,_|

`;
