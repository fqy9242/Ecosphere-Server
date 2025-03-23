## 项目简介

**from 2024-9**

绿色发展同每个人息息相关，每个人都可以做绿色发展的践行者、推动者。中国积极弘扬生态文明价值理念，推动全民持续提升节约意识、环保意识、生态意识，自觉践行简约适度、绿色低碳的生活方式，形成全社会共同推进绿色发展的良好氛围。

为了深入贯彻落实“绿水青山就是金山银山”的发展理念，我们积极响应国家号召，决定开发一款致力于倡导绿色低碳生活，构建全民参与的数字化生态文明社区，以科技创新赋能个人低碳实践，让"绿水青山"理念融入日常生活场景的web应用。

# 技术栈

## 用户端-前端

| IDE      | Visual Studio  Code |
| -------- | ------------------- |
| 开发框架 | Vue3                |
| 脚本语言 | javascript          |
| node版本 | v20.17.0            |
| 构建工具 | Vite                |
| 组件库   | Element plus        |
| 快速构建 | RuoYi v3.8.9        |

## 管理端-前端

## 后端

| **IDE**           | IntelliJ IDEA  2023.2                                 |
| ----------------- | ----------------------------------------------------- |
| 开发语言          | JAVA(JDK21)                                           |
| 开发框架          | Sping boot 3.x                                        |
| 依赖管理          | Maven                                                 |
| 数据库            | Mysql、Redis                                          |
| API接口设计及调试 | Apifox/Postman                                        |
| 数据库管理工具    | Navicat Premium Lite、  Another Redis Desktop Manager |

## **功能预览**



# 部署方式

## 本地运行

- 前端

	1. 克隆项目

	1. 使用vscode或其他工具导入

	1. 项目根目录运行终端输入`run` 如果成功运行则跳过四五步

	1. 安装依赖 `npm i`

	1. 启动 `npm run dev`

	1. 后台管理员账户: `admin` 密码`admin123`

- 后端

	1. 克隆项目 `git clone git@github.com:fqy9242/Ecosphere-Server.git`

	2. 使用idea导入 并安装maven依赖

	2. 更改spring 配置 更改自己的数据库信息![image-20250323190018277](https://q-gallery.oss-cn-guangzhou.aliyuncs.com/img/202503231900373.png)

	3. 配置文件上传OSS相关信息

		1. ![image-20250323190947018](https://q-gallery.oss-cn-guangzhou.aliyuncs.com/img/202503231909100.png)

		

4. 启动redis
5. 配置环境变量 
	1. `AI_DASHSCOPE_API_KEY` => 阿里云通义百炼的key
	2. `OSS_ACCESS_KEY_ID` => 阿里云keyID
	3. `OSS_ACCESS_KEY_SECRET` => 阿里云keySecret
6. 启动spring boot

## Docker运行

1. 配置相关环境变量

2. 懒得写了 配置信息见图

	![image-20250323191432583](https://q-gallery.oss-cn-guangzhou.aliyuncs.com/img/202503231914631.png)
