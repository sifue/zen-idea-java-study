# プロになるJAVA の実行テスト

元のコードは

[https://github.com/projava17/examples/](https://github.com/projava17/examples/)

で確認可能。

## 2025年時検証メモ

- Oracle OpenJDK 25
- IntelliJ IDEA 2025.2.3 (Community Edition)

以上で検証。

### ビルド周り

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

```
    <properties>
        <java.version>25</java.version>
        <maven.compiler.source>25</maven.compiler.source>
        <maven.compiler.target>25</maven.compiler.target>
        <maven.compiler.release>25</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```

以上をpom.xmlに追加でも解決可能。

### Java API ドキュメント
今の所25は英語のみ
[https://www.oracle.com/jp/java/technologies/documentation.html](https://www.oracle.com/jp/java/technologies/documentation.html)

### Java Docの生成

JavaDocのプラグインをpom.xmlに指定

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>3.12.0</version>
                <configuration>
                    <outputDirectory>${project.build.directory}/apidocs</outputDirectory>
                    <release>${maven.compiler.release}</release>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

Ctrl2回からの

```
mvn javadoc:javadoc
```

以上で `target/apidocs/apidocs` にドキュメント生成。

### テスト
JUnitはデフォルトは3.8.1なので、
```
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
```

に変更。

### バージョン管理とGit
IntelliJ IDEAのUIが変わっているので説明することは一緒だが、
UIは全然違うので臨機応変に説明が必要。

特にブランチはGitツールウィンドウのBranchのドロップダウンメニューから
やるが残念ながら、固まったりしてしまうので、もしかしてこれだけコマンドラインで
学ぶとか別のやり方が必要かもしれない。

プロになるJavaの流れをやりつつ、それをコマンドラインとテキストで解説する。
ここだけZEN StudyのWebアプリケーション2の9回、10回をやるのも手。

### Spring Boot

Spring Initializrが古いSpringBootをサポートしなくなっている。
[https://start.spring.io/](https://start.spring.io/)

最新にしつつMavenで行うのが良さそう。(あとでテンプレートエンジンを足すため)
一旦
- Maven
- Java
- Spring Boot 3.5.6
- jp.gihyo.projava
- tasklist
- tasklist
- Spring Bootを使ったタスク管理アプリケーション
- jp.gihyo.projava.tasklist
- Jar
- Java 25
- Spring Web
で作成。