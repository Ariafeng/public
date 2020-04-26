# jenkins-library
Shared Library for Jenkins Pipeline

- 关于Shared Library的更多信息请参考[Using libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/#using-libraries) 

## 配置 Jenkins 使用 Shared Library
若要使用 Shared Library, 您可以通过两种方式进行配置:
- Declarative Pipeline
  通过简单配置使用 `Jenkinsfile` 进行控制

  Jenkinsfile 在执行时, 也是调用了 **Jenkins Shared Library**

- Scripted Pipeline
  通过一些配置使用 `Script` 进行控制

### Declarative Pipeline
#### 1. 创建一个流水线(Pipeline)项目
创建项目

#### 2. 配置使用 Jenkinsfile
在项目配置界面，**流水线** 处:
  - 定义
    - Pipeline script from SCM
      - SCM
        - Git
      - Repository URL
        - https://github.com/Statemood/jenkins-library
      - Branch Specifier (blank for 'any')
        - origin/master
    - 脚本路径
      - Jenkinsfile

保存即可开始使用。

### Scripted Pipeline
#### 1. 保存 `settings.groovy` 到Jenkins本地
   - 如 `/data/jenkins/config/settings.groovy`
   - 确保 Jenkins 运行用户有读取此文件的权限

#### 2. 在 Jenkins 中配置全局变量 `SETTINGS`, 步骤如下：
  - -> Manage Jenkins
    - -> Configure System
      - -> Global properties
      - Create new one
        - Name:  `SETTINGS`
        - Value: `/data/jenkins/config/settings.groovy`
  - 具体 `settings.groovy` 路径请以本地环境配置为准

#### 3. 配置 Global Pipeline Libraries
- 配置方式参考 https://jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries


## 依赖项
BUILD_USER & BUILD_USER_ID 需要 [build user vars](https://plugins.jenkins.io/build-user-vars-plugin) 插件