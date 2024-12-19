# jpa_restful_graphql
使用jpa完成一个简单的restful和graphql查询api，供学习使用

### 查询备注
```graphql
query BookDetails{
  getBookById(id: 1){
    id  
    #别名
    bname: name
    pages
    author{
      id
      name
    }
  }
}
```