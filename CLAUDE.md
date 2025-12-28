# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个Java学习项目,用于演示Java面向对象编程的核心概念。项目使用IntelliJ IDEA作为开发环境,不使用Maven或Gradle构建工具。

## 项目结构

```
src/
├── Java基础._01Class重要小技巧/          # Lombok注解使用示例
│   ├── Card.java            # 演示@Data、@AllArgsConstructor、@NoArgsConstructor
│   └── Main.java
└── Java基础._02super应用/                # 类继承和super关键字示例
    └── Main.java            # 演示父子类构造器调用关系
```

## 开发环境

- **IDE**: IntelliJ IDEA
- **构建方式**: IDEA原生编译(非Maven/Gradle项目)
- **源代码目录**: `src/`
- **编译输出目录**: `out/`
- **JDK配置**: 在IDEA项目设置中配置

## 依赖管理

项目依赖通过IDEA的模块库配置管理,当前依赖:

- **Lombok 1.18.38**: 配置在`JAVADevelopment.iml`中,scope为PROVIDED
  - 位置: Maven仓库 `org.projectlombok:lombok:1.18.38`

### 编译Lombok相关代码

由于使用了Lombok,在命令行编译时需要:

1. **在IDEA中运行**: 直接运行即可,IDEA已集成Lombok支持
2. **命令行编译**: 需要在classpath中包含lombok.jar
   ```bash
   javac -cp "path/to/lombok-1.18.38.jar" src/包名/*.java
   ```

## 包命名规范

项目使用中文包名(学习项目特点):
- `Java基础._01Class重要小技巧`: Class相关技巧
- `Java基础._02super应用`: super关键字应用

注意: 中文包名在不同系统和编码环境下可能导致编译问题。

## 代码架构要点

### 1. Lombok使用模式 (Class重要小技巧包)

**Card.java** 展示了Lombok的三个核心注解:
- `@Data`: 自动生成getter/setter/toString/equals/hashCode
- `@AllArgsConstructor`: 生成全参构造器
- `@NoArgsConstructor`: 生成无参构造器

这种模式减少了样板代码,是现代Java开发的常见实践。

### 2. 继承与构造器调用链 (super应用包)

**Main.java** 中的Father和Son类展示:
- 子类构造器自动调用`super()`(父类无参构造器)
- 显式使用`super(参数)`可调用父类有参构造器
- 父类构造器总是在子类构造器之前执行

## 常见问题

### Lombok编译错误

如果遇到"找不到lombok程序包"错误:
1. 确认IDEA已安装Lombok插件
2. 确认`JAVADevelopment.iml`中配置了lombok依赖
3. 执行IDEA的"Invalidate Caches and Restart"

### 中文包名编译问题

如果命令行编译失败:
1. 确保文件编码为UTF-8
2. 使用`javac -encoding UTF-8`参数
3. 优先在IDEA中运行,避免编码问题
