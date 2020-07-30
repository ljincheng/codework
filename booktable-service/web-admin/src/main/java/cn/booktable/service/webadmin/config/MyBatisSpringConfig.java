package cn.booktable.service.webadmin.config;

/**
 * @author ljc
 */
//@Configuration
//@EnableTransactionManagement
//public class MyBatisSpringConfig implements TransactionManagementConfigurer {
public class MyBatisSpringConfig  {

//    @Autowired
//    private DataSource dataSource;
//
//    // 在Spring中注册SqlSessionFactory，在这里可以设置一下参数：
//    // 1.设置分页参数
//    // 2.配置MyBatis运行时参数
//    // 3.注册xml映射器
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        // 设置数据源
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        // 设置映射POJO对象包名
//        // sqlSessionFactoryBean.setTypeAliasesPackage("org.chench.test.springboot.model");
//
//        // 分页插件
//        /*PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);*/
//        //添加插件
//        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
//
//        // 配置mybatis运行时参数
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        // 自动将数据库中的下划线转换为驼峰格式
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setDefaultFetchSize(100);
//        configuration.setDefaultStatementTimeout(30);
//
//        sqlSessionFactoryBean.setConfiguration(configuration);
//
//        // 在构建SqlSessionFactory时注册xml映射器
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//            return sqlSessionFactoryBean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 注入sqlSession对象
//     * @param sqlSessionFactory
//     * @return
//     */
//    @Bean(value = "sqlSession")
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    // Spring事务管理器
//    @Bean(value = "transactionManager")
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
