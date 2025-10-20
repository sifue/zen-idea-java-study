# プロになるJAVA の実行テスト

元のコードは

[https://github.com/projava17/examples/](https://github.com/projava17/examples/)

で確認可能。

## 2025年時検証メモ

- Oracle OpenJDK 25
- IntelliJ IDEA 2025.2.3 (Community Edition)

以上で検証。

```
java 25 2025-09-16 LTS
Java(TM) SE Runtime Environment (build 25+37-LTS-3491)
Java HotSpot(TM) 64-Bit Server VM (build 25+37-LTS-3491, mixed mode, sharing)
```

以上をOracleからインストールしてスタート。MacでのJAVA_HOMEは以下。

```
echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home/
```

Mavenのアーキテクチャは、quickstartで開始。
ただし、RootのModule Settings > Project > Modulesの
Language Levelを1.8→25へ。

Settings > Build > Compiler からプロジェクトのコンパイラを
1.8→25へ変更。

以上をする必要がある。

16章 16.4.6 で、pom.xmlの同期をすると上記をやり直す必要がある。

