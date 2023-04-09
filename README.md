# junit-order
JUnitテストケース範囲指定実行


## Document
[Wiki Page](../../wiki) を参照

## Setup pom.xml
```
<repositories>
   <repository>
      <id>junit-order</id>
      <url>https://raw.github.com/yipuran/junit-order/mvn-repo</url>
   </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>org.yipuran.junit</groupId>
        <artifactId>junit-order</artifactId>
        <version>1.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

```


## Setup gradle
```
repositories {
    mavenCentral()
    maven { url 'https://raw.github.com/yipuran/junit-order/mvn-repo'  }
}

dependencied {
    compile 'org.yipuran.junit:junit-order:1.0'
}
```


