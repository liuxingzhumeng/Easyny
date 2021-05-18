package easyny.ludashen.com.easyny;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import easyny.ludashen.com.easyny.translate.TransApi;
import easyny.ludashen.com.easyny.util.NyNotice;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private static final String APP_ID = "20190922000336473";
    private static final String SECURITY_KEY = "AHYHOO_1FdyF7p091Ise";
    @Test
    public void addition_isCorrect() throws Exception {

        System.out.print("".length());
    }

    @Test
    public void add() throws IOException {
        Document parse = Jsoup.parse("<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta charset=\"utf-8\"/><meta name=\"referrer\" content=\"always\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\"><link rel=\"shortcut icon\" href=\"https://gss0.bdstatic.com/5bd1bjqh_Q23odCf/static/wiseindex/img/favicon64.ico\" type=\"image/x-icon\"><link rel=\"apple-touch-icon-precomposed\" href=\"https://gss0.bdstatic.com/5bd1bjqh_Q23odCf/static/wiseindex/img/screen_icon_new.png\"><title>家有面粉，一定要做这早餐，比面包油条简单，松软香甜，全家都爱</title><link rel=\"stylesheet\" href=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/css/land_min_pack_adfb465.css\"><meta itemprop=\"dateUpdate\" content=\"2020-02-26 10:36:32\" /></head><body><script >/* eslint-disable */var s_domain = {\"protocol\":\"https:\",\"staticUrl\":\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/\",\"base\":\"\",\"baseuri\":\"\",\"passconf\":\"http://passport.baidu.com/ubrwsbas\",\"logout\":\"https://passport.baidu.com/?logout&u=\",\"bs\":\"https://www.baidu.com\",\"sp\":\"http://hi.baidu.com/\",\"ssllist\":{\"a.hiphotos.baidu.com\":\"ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy\",\"b.hiphotos.baidu.com\":\"ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy\",\"c.hiphotos.baidu.com\":\"ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy\",\"d.hiphotos.baidu.com\":\"ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy\",\"e.hiphotos.baidu.com\":\"ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy\",\"f.hiphotos.baidu.com\":\"ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy\",\"g.hiphotos.baidu.com\":\"ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy\",\"h.hiphotos.baidu.com\":\"ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy\",\"1.su.bdimg.com\":\"ss0.bdstatic.com/k4oZeXSm1A5BphGlnYG\",\"t10.baidu.com\":\"ss0.baidu.com/6ONWsjip0QIZ8tyhnq\",\"t11.baidu.com\":\"ss1.baidu.com/6ONXsjip0QIZ8tyhnq\",\"t12.baidu.com\":\"ss2.baidu.com/6ONYsjip0QIZ8tyhnq\",\"himg.bdimg.com\":\"ss1.bdstatic.com/7Ls0a8Sm1A5BphGlnYG\",\"cdn00.baidu-img.cn\":\"ss0.bdstatic.com/9bA1vGba2gU2pMbfm9GUKT-w\",\"cdn01.baidu-img.cn\":\"ss0.bdstatic.com/9bA1vGfa2gU2pMbfm9GUKT-w\"}};var s_session = {\"ssid\":\"96e71bb6\",\"logid\":\"\",\"sid\":\"122158_142113_128701_142206_141003_141127_142060_135846_142019_141838_140632_139051_140988_142390_142286_140324_140578_133847_140065_131423_141703_107312_139882_140994_140966_137703_136753_110085_141239_142271_141859_142345_138655_138878_137985_136862_140174_131247_137745_138165_138883_140260_141941_127969_140593_138425_141191_141928\",\"nid\":\"10014173407001074724\",\"qid\":\"\"};var s_advert = {\"isBjh\":\"1\",\"contentUrl\":\"http://baijiahao.baidu.com/s?id=1659565078850881217\",\"contentPlatformId\":\"3\",\"contentType\":\"1\",\"pvid\":\"c2409e9b0af200d4\",\"time\":\"2020-02-26 12:41:39\",\"contentAccType\":\"1\",\"ctk\":\"13a164ecda9c3e08\",\"contentAccId\":\"JQfIxI60dRYpB\",\"ctk_b\":\"3a3897d69d67e598\",\"logid\":\"2499840240\",\"dtime\":\"1582692099\",\"grade\":\"2\",\"createTimeAccLevel\":\"4\"};</script><script>/* eslint-disable */var bds={se:{},su:{urdata:[],urSendClick:function(){},urStatic:\"https://ss.bdimg.com\"},util:{},use:{},comm:{domain:\"\",ubsurl:\"\",tn:\"\",queryEnc:\"\",queryId:\"\",inter:\"\",sugHost:\"\",query:\"\",qid:\"\",cid:\"\",sid:\"\",stoken:\"\",serverTime:\"\",user:\"\",username:\"\",loginAction:[],useFavo:\"\",pinyin:\"\",favoOn:\"\",curResultNum:\"0\",rightResultExist:false,protectNum:0,zxlNum:0,pageNum:1,pageSize:10,ishome:1,newindex:1}};var name,navigate,al_arr=[];var selfOpen=window.open;eval(\"var open = selfOpen;\");var isIE=navigator.userAgent.indexOf(\"MSIE\")!=-1&&!window.opera;var E=bds.ecom={};bds.se.mon={loadedItems:[],load:function(){},srvt:-1};try{bds.se.mon.srvt=parseInt(document.cookie.match(new RegExp(\"(^| )BDSVRTM=([^;]*)(;|$)\"))[2]);document.cookie=\"BDSVRTM=;expires=Sat, 01 Jan 2000 00:00:00 GMT\"}catch(e){}var bdUser=bds.comm.user?bds.comm.user:null,bdQuery=bds.comm.query,bdUseFavo=bds.comm.useFavo,bdFavoOn=bds.comm.favoOn,bdCid=bds.comm.cid,bdSid=bds.comm.sid,bdServerTime=bds.comm.serverTime,bdQid=bds.comm.queryId,bdstoken=bds.comm.stoken,login_success=[];</script><div id=\"detail-page\"><div class=\"line-shadow\"></div><div class=\"item-wrap\"><div id=\"header_wrap\" class=\"header_wrap\"><div class=\"header_content\"><div class=\"header_logo\"><a href=\"https://www.baidu.com\" id=\"result_logo\" data-clklog=\"tid:139;cst:2;logInfo:head_logo;\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;\" data-rid=\"head_0\"><img src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/img/logo_top.png\" alt=\"到百度首页\" title=\"到百度首页\"></a></div><div class=\"header_menu\" data-rid=\"header_menu\"><a href=\"https://www.baidu.com\" class=\"index\" data-clklog=\"tid:142;cst:2;logInfo:head_menu\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;type:backindex\" data-rid=\"head_1\">百度首页</a><span class=\"line\"></span><div id=\"userBlock\"><a href=\"https://passport.baidu.com/v2/?login&tpl=mn&u=http://www.baidu.com\" class=\"login\" data-clklog=\"tid:142;cst:2;logInfo:head_menu;\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;type:login\" data-rid=\"head_2\">登录</a><a href=\"http://i.baidu.com/\" id=\"usrname\" class=\"usrname\" data-clklog=\"tid:142;cst:2;logInfo:head_menu;\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;type:usrname;\" data-rid=\"head_2\"><span id=\"nametxt\">零之魔使永恒</span><div id=\"user_menu\" data-showlog=\"tid:131;cst:1;logInfo:usrmenu;\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;\" class=\"s-isindex-wrap s-user-set-menu menu-top\" style=\"display: none;\"><div><a href=\"http://i.baidu.com/center\" target=\"_blank\" data-tid=\"1000\" data-clklog=\"tid:146;cst:2;logInfo:usrmenu;\" data-extralog=\"rid:;pos:1;extra:;isBaiJiaHao:1;login:1;type:center;\" data-rid=\"usr_menu_1\">个人中心</a><a href=\"http://passport.baidu.com/\" data-tid=\"1001\" target=\"_blank\" data-clklog=\"tid:146;cst:2;logInfo:usrmenu;\" data-extralog=\"rid:;pos:2;extra:;isBaiJiaHao:1;login:1;type:passport;\" data-rid=\"usr_menu_2\">帐号设置</a><a class=\"s-feedback\" style=\"overflow:hidden\" href=\"#\" onclick=\"return false;\" data-clklog=\"tid:146;cst:2;logInfo:usrmenu;\" data-extralog=\"rid:;pos:3;extra:;isBaiJiaHao:1;login:1;type:feedback;\" data-rid=\"header_menu_3\">意见反馈</a><a class=\"quit\" style=\"overflow:hidden\" href=\"https://passport.baidu.com/?logout&u=https://www.baidu.com\" data-clklog=\"tid:146;cst:2;logInfo:usrmenu;\" data-extralog=\"rid:;pos:4;extra:;isBaiJiaHao:1;login:1;type:quit;\" data-rid=\"usr_menu_4\">退出</a></div><span class=\"menu-arrow\"><em></em></span></div></div></div></div></div></div><div class=\"title_border\"><div class=\"anci_header_content\"><div class=\"article-title\"><h2>家有面粉，一定要做这早餐，比面包油条简单，松软香甜，全家都爱</h2></div><div class=\"article-desc clearfix\"><div class=\"author-icon\"><img src=\"https://timg01.bdimg.com/timg?pacompress=&amp;imgtype=0&amp;sec=1439619614&amp;autorotate=1&amp;di=ec54894314dab34b2eb917efc54e4bd8&amp;quality=90&amp;size=b200_200&amp;src=http%3A%2F%2Fpic.rmb.bdstatic.com%2F11c15ff5cdcb34e01e48a9322c55c2b8.jpeg\"><i class=\"author-vip author-vip-3\"></i></div><div class=\"author-txt\"><p class=\"author-name\">味谷的厨房</p><div class=\"article-source article-source-bjh\"><span class=\"date\">发布时间：02-26</span><span class=\"time\">10:36</span><span class=\"account-authentication\">百家榜创作者，优质原创作者</span></div></div></div></div></div><div id=\"content-container\" class=\"content-container clearfix\" data-showlog=\"tid:126;cst:1;logInfo:landing;\" data-extralog=\"flow:2;st:news;rid:10014173407001074724;pos:0;extra:;source:1;isBaijiahao:1;login:1;appId:1573425506890973;\" data-ratio=\"1\" data-rid=\"page\"><div id=\"left-container\" class=\"left-container\"><div class=\"item-wrap\"><div class=\"article \" id=\"article\" data-islow-browser=\"0\"><div class=\"article-content\"><p><span class=\"bjh-p\">由于特色时期，不知不觉宅在家里已经是快一个月了，在家里闲得好无聊，不如在家里好好做一些自己喜欢吃的各种美食了，既可以让我们每天的生活更加充实，又可以让我们吃的更加营养健康，还可以晒到朋友圈里成为美食达人了，哈哈。最近几天，好像全国人民都忙着用做蛋糕油条，但我今天给大家分享另一道老少皆宜的面食，形状有点像面包，不需揉面，一搅一蒸就能做好，口感更加的温润香甜，蒸的不上火哟，它就是红糖发糕。</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics4.baidu.com/feed/a8773912b31bb051d3655611fdc49eb24bede08f.jpeg?token=f7b823159b2c9eadb9c14268288ddd07&amp;s=ED5004C6C65211C64C1A353903001058\" data-loaded=0 /></div><p><span class=\"bjh-p\">家里有面粉的，别总做面包油条了，一定要试试这种做法，比面包油条简单，松软香甜，又有枣子的甜味，而且非常的有营养。红糖的好处在于温而补之，温而通之，温而散之，也就是我们俗称的温补。对于女人来说，红糖发糕更是一款经期必备小点心，滋阴补血好处多哦。好吃还不腻，真的是很值得尝试的一款美味，来来来，红糖发糕发起来吧。现在把我红糖发糕的制作过程中分享给大家，希望能够帮到大家。</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics0.baidu.com/feed/38dbb6fd5266d016f0dd7c665e95900137fa35f9.jpeg?token=a62553201bf3a95cdafa1717a5502b84&amp;s=FC5004C696065F5746BF0C2C03008058\" data-loaded=0 /></div><p><span class=\"bjh-p\">红糖发糕</span></p><p><span class=\"bjh-p\">【材料】：红糖粉 100克，温水 200克，面粉 250克，酵母 3克，小苏打 2克，红枣 适量</span></p><p><span class=\"bjh-p\">【做法】：1、用200克温水把红糖粉融化，如果是一块块的红糖就用小锅将红糖煮融；</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics0.baidu.com/feed/eaf81a4c510fd9f9ff296dd8f093902c2934a48d.jpeg?token=1ee97766340e2f2efb49be1926b09d72&amp;s=E82004D2A0553BC60948E1060300E040\" data-loaded=0 /></div><p><span class=\"bjh-p\">2、把红糖水倒入面粉里，放入3克酵母，然后搅拌成无疙瘩的面糊，要搅拌均匀。（如果是用小锅煮的红糖水，要把红糖水晾温才能倒入面粉中）</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics6.baidu.com/feed/8435e5dde71190ef6181c31805a5d910fffa60c7.jpeg?token=1540f79fdc8f3ec49d43f4cad02a65ef&amp;s=CE9034C58CC668C6321DC9780300105B\" data-loaded=0 /></div><p><span class=\"bjh-p\">3、把装有面糊的碗放在温暖的地方发酵2个小时左右，面糊涨到2倍大，扒开面糊能看见里面有很多气孔；</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics4.baidu.com/feed/cefc1e178a82b901d0ceaac7ba33ed713812ef2c.jpeg?token=01760d31f4fe4d20c9ec198889a9277a&amp;s=F2181CC5C922F85D1407CE680300C01A\" data-loaded=0 /></div><p><span class=\"bjh-p\">4、面糊发酵好后用筷子搅拌一下，排出里面的气；</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics6.baidu.com/feed/80cb39dbb6fd52665e6b342f66a6d32dd5073689.jpeg?token=d13b2993b3fbf1de1e958fda1b874ea0&amp;s=93009C44EDFAD8550C871A7B0300C058\" data-loaded=0 /></div><p><span class=\"bjh-p\">5、然后撒入红枣碎，分批放入小苏打搅拌均匀，注意：小苏打一定要充分地搅拌均匀，不能有结块；</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics1.baidu.com/feed/9f2f070828381f30572cf7eb60bf080e6f06f084.jpeg?token=5f15e31a31323344b1a7588a88b30d6d&amp;s=D628BE46091643C6501F256E0300E07A\" data-loaded=0 /></div><p><span class=\"bjh-p\">6、将面糊倒入纸杯或者小碗里，如果用碗，碗底要刷一层油防粘；</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics2.baidu.com/feed/8718367adab44aedc918927e78a2c307a08bfb1f.jpeg?token=50a5647310272545f01be516f7c0c841&amp;s=3338768740C357451337876E0300E078\" data-loaded=0 /></div><p><span class=\"bjh-p\">7、上面再放上一些红枣碎，或者葡萄干都行。锅内烧水，水开后放入锅中，大火隔水蒸25分钟，蒸好后关火焖5分钟即可。</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics2.baidu.com/feed/d009b3de9c82d158f5b30f5148b45ddebd3e4265.jpeg?token=28571fda1da27668000427599748d48c&amp;s=9B38768646437F45583F3A7C0300507A\" data-loaded=0 /></div><p><span class=\"bjh-p\">超级松软的红糖发糕出锅，没有人能够拒绝带有浓浓枣香味的红糖发糕。</span></p><div class=\"img-container\"><img class=\"large\" data-loadfunc=0 src=\"https://pics6.baidu.com/feed/7a899e510fb30f24eae3f0601a2b9545ac4b0398.jpeg?token=79eed128c88d618a54afda3c22d14369&amp;s=AD500CC6CA1271D64C02353803001058\" data-loaded=0 /></div><p><span class=\"bjh-p\">【小提示】：</span></p><p><span class=\"bjh-p\">1、前一天晚上可以将面团材料全部搅拌好，搁置发酵一晚上就好，第二天早上上锅蒸！</span></p><p><span class=\"bjh-p\">2、蒸好后一定要焖5分钟之后再开锅盖。</span></p><p><span class=\"bjh-blockquote\"><span class=\"bjh-p\">此图文作品系味谷的厨房原创，严禁不良自媒体搬运及盗图，作者保留追究法律责任的权利。你的关注、留言和转发将是对我最大的帮助与动力，也欢迎您提出宝贵的意见和建议，我会每天分享新的文章给大家。</span></span></p></div><audio height=\"0\" width=\"0\" id=\"musicAudio\" data-play-index><source></source></audio></div></div></div><div id=\"right-container\" class=\"right-container\"><div class=\"item-wrap\"><div class=\"recent-article\" data-pos=\"\"><h2>作者最新文章</h><ul><li data-showlog=\"tid:135;cst:1;logInfo:recent_article;\" data-extralog=\"rid:;pos:0;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"recent_article_0\"><h3 class=\"item-title\"><a href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_10014173407001074724%22%7D&amp;n_type=1&amp;p_from=3\" data-clklog=\"tid:147;cst:2;logInfo:recent_article;\" data-extralog=\"rid:;pos:0;extra:;isBaiJiaHao:1;login:1;\" target=\"_blank\">家有面粉，一定要做这早餐，比面包油条简单，松软香甜，全家都爱</a></h3><div class=\"item-desc hide\"><span class=\"info-date\">02-26</span><span class=\"info-time\">10:39</span></div></li><li data-showlog=\"tid:135;cst:1;logInfo:recent_article;\" data-extralog=\"rid:;pos:1;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"recent_article_1\"><h3 class=\"item-title\"><a href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9752057192325585589%22%7D&amp;n_type=1&amp;p_from=3\" data-clklog=\"tid:147;cst:2;logInfo:recent_article;\" data-extralog=\"rid:;pos:1;extra:;isBaiJiaHao:1;login:1;\" target=\"_blank\">6款零食在家做，简单方便，比买的还好吃，发朋友圈被点赞无数</a></h3><div class=\"item-desc hide\"><span class=\"info-date\">02-25</span><span class=\"info-time\">20:34</span></div></li><li data-showlog=\"tid:135;cst:1;logInfo:recent_article;\" data-extralog=\"rid:;pos:2;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"recent_article_2\"><h3 class=\"item-title\"><a href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9513591446745279293%22%7D&amp;n_type=1&amp;p_from=3\" data-clklog=\"tid:147;cst:2;logInfo:recent_article;\" data-extralog=\"rid:;pos:2;extra:;isBaiJiaHao:1;login:1;\" target=\"_blank\">想吃三杯鸡不用下馆子，教你懒人做法，鸡肉嫩滑又入味，家人爱吃</a></h3><div class=\"item-desc hide\"><span class=\"info-date\">02-25</span><span class=\"info-time\">15:13</span></div></li></ul></div></div><div class=\"item-wrap\"><div class=\"related-news\"><div class=\"news-content \"><h2>相关文章</h2><ul><li data-showlog=\"tid:136;cst:1;logInfo:related_news;\" data-extralog=\"flow:2;rid:;pos:0;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"related_news_0\"><div class=\"item-content clearfix\"><div class=\"news-info\"><div class=\"news-title\"><h3><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:0;extra:;isBaiJiaHao:1;login:1;type:'title'\"  href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9293787608952541374%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\">土豆烧排骨，简单好做，非常下饭哦！</a></h3></div></div><div class=\"news-pic\"><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:1;extra:;isBaiJiaHao:1;login:1;type:'img'\" href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9293787608952541374%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\"><img src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1740500874,1243051053&amp;fm=173&amp;app=49&amp;f=JPEG?w=312&amp;h=208&amp;s=F03816D5480749455A1A75AB03005008\"></a></div></div></li><li data-showlog=\"tid:136;cst:1;logInfo:related_news;\" data-extralog=\"flow:2;rid:;pos:1;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"related_news_1\"><div class=\"item-content clearfix\"><div class=\"news-info\"><div class=\"news-title\"><h3><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:1;extra:;isBaiJiaHao:1;login:1;type:'title'\"  href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9393784880121448449%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\">土豆这样做，身价翻100倍！简单精致又好吃，刷爆朋友圈！</a></h3></div></div><div class=\"news-pic\"><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:2;extra:;isBaiJiaHao:1;login:1;type:'img'\" href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9393784880121448449%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\"><img src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3479543203,2211818418&amp;fm=173&amp;app=49&amp;f=JPEG?w=312&amp;h=208&amp;s=39E04E914C50B6C206B0452403007042\"></a></div></div></li><li data-showlog=\"tid:136;cst:1;logInfo:related_news;\" data-extralog=\"flow:2;rid:;pos:2;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"related_news_2\"><div class=\"item-content clearfix\"><div class=\"news-info\"><div class=\"news-title\"><h3><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:2;extra:;isBaiJiaHao:1;login:1;type:'title'\"  href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_10127559452704835593%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\">二月二龙抬头，这3种“龙食”别忘记吃，一年健康又顺利</a></h3></div></div><div class=\"news-pic\"><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:3;extra:;isBaiJiaHao:1;login:1;type:'img'\" href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_10127559452704835593%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\"><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2678555714,4011700134&amp;fm=173&amp;app=49&amp;f=JPEG?w=312&amp;h=208&amp;s=B8164F94544B5AE04CA46B4C0300C070\"></a></div></div></li><li data-showlog=\"tid:136;cst:1;logInfo:related_news;\" data-extralog=\"flow:2;rid:;pos:3;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"related_news_3\"><div class=\"item-content clearfix\"><div class=\"news-info\"><div class=\"news-title\"><h3><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:3;extra:;isBaiJiaHao:1;login:1;type:'title'\"  href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9664627068324403227%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\">让人“拍案叫绝”的中国名菜，刀工堪比飙车！</a></h3></div></div><div class=\"news-pic\"><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:4;extra:;isBaiJiaHao:1;login:1;type:'img'\" href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9664627068324403227%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\"><img src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2351395845,1616172402&amp;fm=173&amp;app=49&amp;f=JPEG?w=312&amp;h=208&amp;s=DAB031C602B725966CA4B0AC0300E040\"></a></div></div></li><li data-showlog=\"tid:136;cst:1;logInfo:related_news;\" data-extralog=\"flow:2;rid:;pos:4;extra:;isBaiJiaHao:1;login:1;\"  data-rid=\"related_news_4\"><div class=\"item-content clearfix\"><div class=\"news-info\"><div class=\"news-title\"><h3><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:4;extra:;isBaiJiaHao:1;login:1;type:'title'\"  href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9861282544259610554%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\">店门口直接卖菜，堂食改主打外卖，如今的火锅市场不好过</a></h3></div></div><div class=\"news-pic\"><a class=\"upgrade\" data-clklog=\"tid:148;cst:2;logInfo:related_news;\" data-extralog=\"rid:;pos:5;extra:;isBaiJiaHao:1;login:1;type:'img'\" href=\"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9861282544259610554%22%7D&amp;n_type=1&amp;p_from=4\" target=\"_blank\"><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1201751798,3545520335&amp;fm=173&amp;app=49&amp;f=JPEG?w=312&amp;h=208&amp;s=70383ED744207507623BD9FE03008038\"></a></div></div></li></ul></div></div><div id=\"relateAd\" ad-id=\"relate-js\" class=\"wangmeng-ad\" data-showlog=\"tid:369;cst:1;logInfo:adsjs;\" data-clklog=\"tid:370;cst:2;logInfo:adsjs;\" data-extralog=\"rid:;pos:5;extra:;baijiahao:1;login:1;\"></div></div></div></div><div id=\"bottom-container\" class=\"bottom-container \"><div class=\"copy-right\"><div class=\"baidu-info\"><a class=\"sethome\" href=\"//www.baidu.com/cache/sethelp/index.html\" target=\"_blank\"><span>设为首页</span></a><span class=\"copyright-text\"><span>&#169;&nbsp;Baidu&nbsp;</span><a href=\"//www.baidu.com/duty/\" target=\"_blank\">使用百度前必读</a>&nbsp;<a href=\"http://jianyi.baidu.com\" target=\"_blank\">意见反馈</a>&nbsp;<span>京ICP证030173号&nbsp;</span><img width=13 height=16 src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/copy_rignt_24.png\" /></span></div><div class=\"recordcode\"><a href=\"http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000001\"  target=\"_blank\"><i></i>京公网安备11000002000001号</a></div></div><div class=\"back-to-top\" data-showlog=\"tid:133;cst:1;logInfo:back_to_top;\" data-clklog=\"tid:138;cst:2;logInfo:back_to_top;\" data-extralog=\"rid:;pos:;extra:;isBaiJiaHao:1;login:1;\" data-rid=\"back_to_top\"><div class=\"icon-text\"><span>返回顶部</span></div><div class=\"icon-arrow\"><span></span></div></div></div></div><script type=\"text/javascript\">window.onload = function () {var contentContainer = document.getElementById('content-container');var bottomContainer = document.getElementById('bottom-container');var rightContainer = document.getElementById('right-container');var minContentHeight = window.innerHeight - bottomContainer.offsetHeight;if (contentContainer.offsetHeight < minContentHeight) {contentContainer.style.height = minContentHeight + 'px';bottomContainer.className += ' fixed';}if (rightContainer.children.length === 0) {rightContainer.style.width = parseInt(rightContainer.offsetWidth + 1, 10) + 'px';}};</script><script type=\"text/javascript\" src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/js/lib/jquery_0affbc1.js\"></script><script type=\"text/javascript\" src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/js/land_min_pack_8e22d87.js\"></script><script type=\"text/javascript\" src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/js/article/index_bd58962.js\"></script></body></html>");
        System.out.print(parse.body().text());

    }

}