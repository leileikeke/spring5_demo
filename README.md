# spring5_demo
# 哔哩哔哩ssm学习笔记--spring5
# Spring -- 爱的初体验

## 简介

​       Spring是一个开放源代码的设计层面框架，他解决的是业务逻辑层和其他各层的松耦合问题，因此它将面向接口的编程思想贯穿整个系统应用。Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EE full-stack(一站式) [轻量级](https://baike.baidu.com/item/轻量级/10002835)开源框架。

### 特点

------



**1.方便解耦，简化开发**

​	通过Spring提供的IoC容器，我们可以将对象之间的依赖关系交由Spring进行控制，避免硬编码所造成的过度程序耦合。有了Spring，用户不必再为单实例模式类、属性文件解析等这些很底层的需求编写代码，可以更专注于上层的应用。

 

**2.AOP编程的支持**

​	通过Spring提供的[AOP](https://baike.baidu.com/item/AOP)功能，方便进行面向切面的编程，许多不容易用传统OOP实现的功能可以通过AOP轻松应付。

 

**3.声明式事务的支持**

​	在Spring中，我们可以从单调烦闷的事务管理代码中解脱出来，通过声明式方式灵活地进行事务的管理，提高开发效率和质量。

 

**4.方便程序的测试**

​	可以用非容器依赖的编程方式进行几乎所有的测试工作，在Spring里，测试不再是昂贵的操作，而是随手可做的事情。例如：Spring对Junit4支持，可以通过注解方便的测试Spring程序。

 

**5.方便集成各种优秀框架**

​	Spring不排斥各种优秀的开源框架，相反，Spring可以降低各种框架的使用难度，Spring提供了对各种优秀框架（如Struts,Hibernate、Hessian、Quartz）等的直接支持。

 

**6.降低Java EE API的使用难度**

​	Spring对很多难用的Java EE API（如JDBC，JavaMail，远程调用等）提供了一个薄薄的封装层，通过Spring的简易封装，这些Java EE API的使用难度大为降低。

 

**7.Java 源码是经典学习范例**

​	Spring的源码设计精妙、结构清晰、匠心独运，处处体现着大师对[Java设计模式](https://baike.baidu.com/item/Java设计模式)灵活运用以及对Java技术的高深造诣。Spring框架源码无疑是Java技术的最佳实践范例。如果想在短时间内迅速提高自己的Java技术水平和应用开发水平，学习和研究Spring源码将会使你收到意想不到的效果。

### 优点

------

> 1.低侵入式设计，代码污染极低
> 2.独立于各种[应用服务器](https://baike.baidu.com/item/应用服务器)，基于Spring框架的应用，可以真正实现Write Once,Run Anywhere的承诺
> 3.Spring的DI机制降低了[业务对象](https://baike.baidu.com/item/业务对象)替换的复杂性，提高了组件之间的解耦
> 4.Spring的AOP支持允许将一些通用任务如安全、事务、日志等进行集中式管理，从而提供了更好的复用
> 5.Spring的ORM和DAO提供了与第三方持久层框架的良好整合，并简化了底层的数据库访问
> 6.Spring并不强制应用完全依赖于Spring，开发者可自由选用Spring框架的部分或全部

## 环境搭建

1. 导入依赖
2. 编写一个Spring的配置文件
3. 通过Spring的应用程序获取上下文(Context)对象

![Spring关系模型](C:\Users\leike\Documents\我的md笔记\images\Spring关系模型.png)

### 步骤

#### > 依赖

```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.0.8.RELEASE</version>
    </dependency>
```

#### > 配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--
        将对象的创建交给Spring容器  ,  在这个配置文件里面去声明我要什么对象
        class: 写java类的权限定类名 , 它是通过全类名然后使用反射的技术进行创建的
        id:    Id就是给这个对象在整个应用程序的上下文中取名字以方便区分.
    -->
    <!--注入,配置元数据-->
    <bean class="com.leike.pojo.Girl" id="girl">
        <property name="name" value="王菲"></property>
        <property name="id" value="1"></property>
        <property name="sex" value="女"></property>
    </bean>

</beans>
```

#### > 测试

```java
    @Test
    public void test1() {

        // 1 获取上下文对象 , Spring里面声明对象都需要通过上下文对象获取
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2 通过这个对象获取我们的girl
        Girl g = (Girl) context.getBean("girl");
        
        System.out.println(g);
    }
```

## 核心内容

------

- IOC

- AOP

    IOC概念:

    ​			控制反转(Inverse of control) : 什么控制 , 谁反转了谁?

    控制: 创建对象 , 彼此关系的权利.

    控制权是在开发人员在程序代码当中进行掌控 . new

    夺取控制权

    反转给spring的容器.

    ```
    - 声明要什么
    - spring容器来进行具体的控制
    ```

    改变了编程的方式.

    依赖注入( DI )

    依赖:

### 容器

```
![Spring依赖注入](C:\Users\leike\Documents\我的md笔记\images\Spring依赖注入.png)
```

- pojos : 自己定义的类
- metadata : 在Spring的配置文件里面写的这些就是元数据
- 实例化容器: classpath . . . . 将配置文件传入.实例化完毕

### 值的注入

- setter 注入(最常用的)

    - 必须其字段有对应setter方法才可以完成  ps: name setName()
    - 通过property子节点完成注入

    如果没有对应的set方法:

    ```java
    Bean property 'name' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
    ```

    

- 构造注入

    注意: 

    ​	默认是通过有参构造构造器完成对象的创建的

    - 如果没有有参构造器

    ```java
    No default constructor found; nested exception is java.lang.NoSuchMethodException
    ```

    - 构造注入有三种方式 (name,index,数据类型)  只推荐name注入

        ```xml
            <bean class="com.leike.pojo.Girl" id="girl2">
                <constructor-arg name="id" value="1"/>
                <constructor-arg name="name" value="王小丫"/>
                <constructor-arg name="sex" value="6"/>
            </bean>
        ```

        

## bean元素探讨

------



### 属性探讨---配置如图

- 'abstract' : 抽象类   改bean无法被实例化

- parent : 指定它的父bean是谁,将会继承父bean

- destroy-method:指定这个bean最后销毁的时候一定执行的方法,适合于清理型工作,触发条件是必须bean确实是被销毁才会发生

    - 容器close会触发
    - refresh也会触发

- iinit-method  :  指定bean的初始化方法,准备性的工作.

- name : 别名,可以通过它一样查找   可以写多个,(彼此分割可以用多种符号-->空格,逗号等等)

    - <alias>标签声明别名

        ```xml
            <alias name="dog" alias="旺财"/>
        
        ```

        

- scopr :  指定范围

    - singleton: 单例 , spring上下文当中,只有一个实例.
    - prototype: 原型: 要一个就给新的一个.

- lazy-init :  延时加载  默认为false,当设为true的时候 只有用它的时候才会初始化。

    - 直接初始化
        - 他应用程序启动会慢一点,内存消耗更大一点
        - 当我们使用bean的时候会快一点
    - 延时初始化
        - 程序启动快一点,内存消耗更小一些
        - 使用bean会满一些

- depend-on : 依赖的bean , 如果某一个bean的使用严重依赖于另一个bean的准备的话,就可以配置depeand-on。

```xml
<beans >
    <bean class="com.leike.pojo.Girl" id="girl" abstract="true" destroy-method="xiezhuang" init-method="huazhuang">
        <property name="id" value="1"></property>
    </bean>
    <!--test2()-->
    <bean class="com.leike.pojo.Girl" id="youGirl" parent="girl" >
        <property name="name" value="王菲"></property>
        <property name="sex" value="女"></property>
    </bean>
    <!--test3()-->
    <bean class="com.leike.pojo.Girl" id="mygirl" parent="girl" name="g g2 g3 g4" >
        <property name="name" value="王菲"></property>
        <property name="sex" value="女"></property>
    </bean>
    <!--test4()-->
    <bean class="com.leike.pojo.Boy" id="boy" depends-on="dog"></bean>
    <bean class="com.leike.pojo.Dog" id="dog"></bean>
</beans>

```

- 类中类 -- 只能通过ref来引用

    ```xml
        <bean class="com.leike.pojo.People" id="people">
            <property name="dog" ref="dog"></property>
        </bean>
        <bean class="com.leike.pojo.Dog" id="dog"></bean>
    
    ```

    

## spring当中的各种值的注入

------

- 数组 

    ```xml
            <property name="friends">
                <!--数组类型-->
                <list>
                    <value>郭富城</value>
                    <value>黎明</value>
                </list>
            </property>
    
    ```

    

- List

    ```xml
            <property name="nums">
                <!--List类型-->
                <array>
                    <value>1</value>
                    <value>2</value>
                    <value>3</value>
                </array>
            </property>
            <property name="dogs">
                <list>
                    <!--内部bean无法被外部所引用 所以无需ID-->
                    <bean class="com.leike.pojo.Dog">
                        <property name="name" value="旺财"></property>
                    </bean>
                    <bean class="com.leike.pojo.Dog">
                        <property name="name" value="小强"></property>
                    </bean>
                </list>
            </property>
    
    ```

    

- Set

    ```xml
            <property name="pigs">
                <set>
                    <bean class="com.leike.pojo.Pig">
                        <property name="name" value="小强一号"></property>
                    </bean>
                    <bean class="com.leike.pojo.Pig">
                        <property name="name" value="小强二号"></property>
                    </bean>
                </set>
            </property>
    
    ```

    

- Map

```xml
        <property name="userMap">
            <map>
                <entry key="user1">
                    <bean class="com.leike.pojo.User">
                        <property name="name" value="小人儿1号"></property>
                        <property name="address" value="小人国"></property>
                    </bean>
                </entry>
                <entry key="User2">
                    <bean class="com.leike.pojo.User">
                        <property name="name" value="小人儿2号"></property>
                        <property name="address" value="小人国"></property>
                    </bean>
                </entry>
            </map>
        </property>

```



## 自动注入

------

- autowire属性 -- aotuwire自动寻找  --  primary默认值为true,后宫之主
    - byType : 按照数据类型注入
    - byName : 按照name注入
    - byConstructor :  
    - default
    - none : 不注入

![autowire属性](C:\Users\leike\Documents\我的md笔记\images\autowire属性.png)

## 零碎的知识

------

- 如何引入外部文件

- 如何通过表达式引入 properties 的键值

    建立相关bean  ,  建立先.properties资源文件 , 然后写spring.xml注入  例  :  jdbc配置文件引入

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xmlns:c="http://www.springframework.org/schema/c"
           xmlns:cache="http://www.springframework.org/schema/cache"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:jee="http://www.springframework.org/schema/jee"
           xmlns:lang="http://www.springframework.org/schema/lang"
           xmlns:p="http://www.springframework.org/schema/p"
           xmlns:task="http://www.springframework.org/schema/task"
           xmlns:util="http://www.springframework.org/schema/util"
           xsi:schemaLocation="http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.3.xsd
    		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
    		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
    		http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.3.xsd
    
    		http://www.springframework.org/schema/cache http://www.springframework.org/schema/cache/spring-cache-4.3.xsd
    		http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.3.xsd
    		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    		http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang-4.3.xsd">
        <context:property-placeholder location="classpath:jdbc.properties"/>
    
        <bean class="com.leike.dao.ProviderDao" id="providerDao">
            <!--  ${} 表达式可以去引用我们引入的这些properties里面的属性的值通过他健名来得到值-->
            <property name="url" value="${url}"/>
            <property name="driver" value="${driver}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </bean>
    </beans>
    
    ```

- import(从一个配置文件引入多个配置文件)   以及    context:property-placeholder(见上↑)的使用

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
        
        <!--spring-*.xml   代指同一路径下的所有 spring-xxx.xml 文件-->
        <import resource="classpath:spring/spring-*.xml"></import>
        
    </beans>
    
    ```

# 面试题

# [spring中的BeanFactory与ApplicationContext的作用和区别](https://www.cnblogs.com/goodbye-lazy/p/10546168.html)

#### **BeanFactory 和ApplicationContext** 

Bean 工厂（com.springframework.beans.factory.BeanFactory）是Spring 框架最核心的接口，它提供了高级IoC 的配置机制。
应用上下文（com.springframework.context.ApplicationContext）建立在BeanFactory 基础之上。
几乎所有的应用场合我们都直接使用ApplicationContext 而非底层的BeanFactory。

1. BeanFactory负责读取bean配置文档，管理bean的加载，实例化，维护bean之间的依赖关系，负责bean的声明周期。

2. ApplicationContext除了提供上述BeanFactory所能提供的功能之外，还提供了更完整的框架功能：

    a. 国际化支持

    b. 资源访问: Resources rs = ctx.getResources("classpath:config.properties"),"file:c:/config.properties"

    c. 时间传递: 通过实现ApplicationContextAware接口

3. ###### 常用的获取ApplicationContext的方法:

    - FileSystemXmlApplicationContext的方法:

    - ClassPathXmlApplicationContext的方法:

        FileSystemXmlApplicationContext：从文件系统或者url指定的xml配置文件创建，参数为配置文件名或文件名数组

        ClassPathXmlApplicationContext：从classpath的xml配置文件创建，可以从jar包中读取配置文件

        ClassPathXmlApplicationContext：从classpath的xml配置文件创建，可以从jar包中读取配置文件

    WebApplicationContextUtils：从web应用的根目录读取配置文件，需要先在web.xml中配置，可以配置监听器或者servlet来实现

    ```xml
    <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <servlet>
    <servlet-name>context</servlet-name>
    <servlet-class>org.springframework.web.context.ContextLoaderServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    </servlet>
    
    ```

    这两种方式都默认配置文件为web-inf/applicationContext.xml，也可使用context-param指定配置文件：

    ```xml
    <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/myApplicationContext.xml</param-value>
    </context-param>
    
    ```

 # SpringAOP

###### AOP一一面向切面编程，编程的关注点不同 

- *Aspect(切面) : Aspect声明类似于java中的类声明 , 在Aspect中会包含着一些 Pointcut以及对应的Advice*
- *JoingPoint (连接点) : 表示在程序中明确定义的点,典型的包括方法调用,对类成员的访问以及异常处理程序块的执行等等,他自身还可以嵌套其他jointpoint.*
- *Pointcut (切点) : 表示一组jointpoint,这些jiontpoint或者通过逻辑关系组合起来,或者是通过配置 , 正则表达式等方式集中起来,他定义了相应的Advice将要发生的地方.*
- *Advice (增强) : Advice定义了再pointcut里面定义的程序点具体要做的操作 , 他通过before,after和around来区别实在每个jointpoint之前,之后还是代替执行的代码.*
- *Target (目标对象) : 织入advice的目标对象.*
- *Waecing (织入) :    将asoect和其他对象连接起来,并创建Advice d object的过程.*



## Spring常用注解

- component (意思为组件)
- controller (springmvc controlle层)
- service (业务层)
- repositoty (dao层)

## AOP.XML版配置步骤

1. xml配置激活

2. 注册一个切面要是用的类

3. 配置切入点等等信息

4. 配置测试类(service层)

    ```xml
       <!-- 1.aop是基于代理完成的，所以我们要激活我们的自动代理-->
        <aop:aspectj-autoproxy/>
    
        <!-- 2.注册一个切面要使用的类 -->
        <bean class="com.leike.advice.BeforeAdice" id="beforeAdice">
        </bean>
    
        <!-- 3.配置切入点等等信息-->
        <aop:config>
            <aop:aspect id="beforeAspect" ref="beforeAdice">
                <!--
                    aop:before 表明他确实是前置通知
                    method：指明他使用哪个方法来切。
                    pointcut:切入点
                                你要什么包下面的什么类下面的什么方法
                                pointcut="execution(* com.leike.service.*.*(..))"
                -->
                <aop:before method="methodBefore" pointcut="execution(void com.leike.service.ProviderService.add())"></aop:before>
            </aop:aspect>
        </aop:config>
    
        <bean class="com.leike.service.ProviderService" id="providerService">
    	
    	</bean>
    ```

## AOP-@注解版配置步骤

### 配置步骤

1. 激活代理(和配置版相同)

2. 配置基础扫描包(扫描路径下含有@Component注解的类)

3. 配置service层的需要被切的类(非必须 , 和aop无直接关联,只是测试需要)

    ```java
    @Aspect  //标记其为一个切面
    @Component //标记这个类为Spring的一个组件,相当于在xml中注册了一个bean一样
    public class AbanAdvice {
    
        @Before("execution(* com.leike.aban_service.AbanService.show(String))")
        public void before() {
            System.out.println("注解版的before,方法执行前");
        }
    
        @Order(1)
        @Before("execution(* com.leike.aban_service.AbanService.show(String))")
        public void before2() {
            System.out.println("");
        }
    
        @After("execution(* com.leike.aban_service.AbanService.show(String))")
        public void after(JoinPoint joinPoint) {
            System.out.println(joinPoint.getSignature().getName());
            System.out.println(Arrays.toString(joinPoint.getArgs()));
            System.out.println("注解版的after,方法执行结束");
        }
    
    //    @AfterThrowing(value = "execution(* com.leike.aban_service.AbanService.throwmethon())",throwing = "throwMsg")
    //    @AfterThrowing(pointcut="execution(* com.leike.aban_service.*(..))", throwing= "error")
        @AfterThrowing(throwing="ex"
                , pointcut="execution(* com.leike.aban_service.AbanService.throwmethon())")
    
        public void afterThrowing(JoinPoint joinPoint,Throwable ex){
    
            System.out.println("异常之后"+joinPoint.getSignature().getName());
            System.out.println("异常信息"+ex);
    
        }
    }
    ```

### 常用注解及解释

- **@Aspect**

- **@Component**

    ```
    Spring 中提供@Component 的三个衍生注解:(功能目前来讲是一致的)
    @Controller:WEB层
    @Service:业务层
    @Repository:持久层
    这三个注解是为了让标注类本身的用途清晰，Spring后续会增强其功能
    ```

- **@Before**

- @**After**

- **@Order**

- **@AfterThrowing**

- **@around**

### execution表达式

先写访问修饰符 包名的限定 类目 方法名 参数列表 + 组合条件符合 , 同时符合两个条件,多个条件都可以.

```xml
publice com.leike..*.*(java.lang.String)
访问修饰符为public的并且是leike这个包下面的任意的类的任意的方法的参数为一个,并且类型为String的方法,就可以切到
public com.leike.*.*()

protected com.leike.*.*()
protected com.leike.*.*.*(java.lang.Integer,...)
```

# Spring 注解配置类

- Configuration : 标记一个类要给配置类 , 然后程序启动的时候只要扫描这个类 , 就可以清楚所有的哦诶之规则

- Comonent: 表明一个类为Spring的一个组件,可以被Spring的一个组件 , 可以被spring容器所管理 , 他是要给普通组件的语义

- Service: 同上,语义上属于dao层.

- Repository: 同上,语义上属于DAO层

- Controller : 同上 , 语义上属于控制层

- ComponentScan : 组件扫描 , 可以绝对去扫描那些包.

    ```java
    @Configuration
    @ComponentScan(value = "com.leike.zhujiekaifa")
    public class SpringConfig {
        @Bean("dog")
        public Dog createDog() {
            Dog dog = new Dog();
            dog.setName("大黄狗");
            return dog;
        }
    ```

    

- Bean : 用于在Spring容器当中注册一个Bean.

    ```java
    @Component(value = "girl")
    public class Girl {}
    ```

    

- Autowired : 用于自动注入组件

    ```java
    @Service("billService")
    public class BillService {
        @Autowired    //自动注入
        private BillDao billDao;
        public void pay(double money){
            System.out.println("Bill Service pay...");
            billDao.pay(money);
        }
    ```

### 测试

- 方式1 通过注解在实体类上   然后自动注入来完成

    ```java
        @Test
        public void t3(){
            ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
            BillService billService = context.getBean("billService", BillService.class);
            billService.pay(4234.13);
        }
    ```

- 方式二   通过配置资源类 来实例化声明(不同于xml   不需要用反射)

```java
    @Test
    public void t2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BillService billService = context.getBean("billService", BillService.class);
        BillDao billDao = context.getBean("billDao", BillDao.class);
        billService.setBillDao(billDao);
        billService.pay(4234.13);
    }

```

### 注意  XML和注解方式的区别

1. 读取配置文件的时候      

    - 注解方式

        ```java
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        ```

    - XML方式

        ```java
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        
        ```

2. 激活代理 和 配置基础扫描包 的时候

    - 注解方式

        ```java
        @Configuration
        @ComponentScan( value = "com.leike")
        @EnableAspectJAutoProxy
        public class SpringConfig {
        }
        
        ```

    - xml方式

        ```xml
            <!--第一步,激活代理-->
            <aop:aspectj-autoproxy/>
            <!--第二步,配置基础扫描包-->
            <context:component-scan base-package="com.leike"/>
        
        ```

        

        















