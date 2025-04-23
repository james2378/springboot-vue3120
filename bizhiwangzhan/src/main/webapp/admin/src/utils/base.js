const base = {
    get() {
        return {
            url : "http://localhost:8080/bizhiwangzhan/",
            name: "bizhiwangzhan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/bizhiwangzhan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "壁纸网站"
        } 
    }
}
export default base
