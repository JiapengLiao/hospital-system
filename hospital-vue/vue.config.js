module.exports = {
    publicPath: "./",
    assetsDir: './',
    devServer: {
        // 设置代理
        proxy: {
            '/api': {
                target: 'http://localhost:9000',//此处可以换成自己需要的地址
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }

            }
        }
    },
}