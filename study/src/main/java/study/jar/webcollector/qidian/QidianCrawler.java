package study.jar.webcollector.qidian;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * Crawling news from hfut news
 *
 * @author hu
 */
public class QidianCrawler extends BreadthCrawler {
    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public QidianCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*种子页面*/
        this.addSeed("http://r.qidian.com/recom?chn=4&dateType=1&style=2&page=1");
        /*正则规则设置*/
        /*爬取符合 http://news.hfut.edu.cn/show-xxxxxxhtml的URL*/
        /*不要爬取 jpg|png|gif*/
//        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*不要爬取包含 # 的URL*/
//        this.addRegex("-.*#.*");
//        this.addSeed("http://book.qidian.com/info/3548786");
        //符合这些正则的页面
        this.addRegex("http://book.qidian.com/info/3548786");
        this.addRegex("http://book.qidian.com/info/1003354631");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        String contentType = page.contentType();
        System.out.println(url);
        System.out.println(page.doc().title()+"===============================");
//        IOs..writeAndClose("E:\\"+page.doc().title(), page.html());
        //System.out.println(page.getHtml());
    }

    public static void main(String[] args) throws Exception {
        QidianCrawler crawler = new QidianCrawler("qidian", true);
        /*线程数*/
        crawler.setThreads(50);
        /*设置每次迭代中爬取数量的上限*/
        crawler.setMaxExecuteCount(5000);
        /*设置是否为断点爬取，如果设置为false，任务启动前会清空历史数据。
           如果设置为true，会在已有crawlPath(构造函数的第一个参数)的基础上继
           续爬取。对于耗时较长的任务，很可能需要中途中断爬虫，也有可能遇到
           死机、断电等异常情况，使用断点爬取模式，可以保证爬虫不受这些因素
           的影响，爬虫可以在人为中断、死机、断电等情况出现后，继续以前的任务
           进行爬取。断点爬取默认为false*/
        //crawler.setResumable(true);
        /*开始深度为4的爬取，这里深度和网站的拓扑结构没有任何关系
            可以将深度理解为迭代次数，往往迭代次数越多，爬取的数据越多*/
        crawler.start(4);
    }

}