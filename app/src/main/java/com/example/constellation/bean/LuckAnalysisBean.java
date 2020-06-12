package com.example.constellation.bean;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.bean
 * 文件名： LuckAnalysisBean
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 16:30
 * 描述：TODO
 */

import java.util.List;

public class LuckAnalysisBean {


    /**
     * resultcode : 200
     * error_code : 0
     * today : {"date":20200528,"name":"狮子座","QFriend":"射手座","color":"绿色","datetime":"2020年05月28日","health":"60","love":"70","work":"70","money":"60","number":8,"summary":"今天的狮子宝宝们会发现人际关系一度陷入紧张状态，自己已经一改平日的强势风格，变得善解人意，但对方依旧不依不饶，让你很头疼。今天也是犯烂桃花和三角恋的一天，今天也是你施展魅力的一天。","all":"75","resultcode":"200","error_code":0}
     * tomorrow : {"date":20200529,"name":"狮子座","QFriend":"摩羯座","color":"黑色","datetime":"2020年05月29日","health":"70","love":"70","work":"70","money":"80","number":1,"summary":"今天有伴儿的狮子宝宝们会觉得另一半特别不近人情，会因僵硬的关系而影响心情。同时部分狮子宝宝也会出现挖墙脚的人，一定不能动摇哦，对方是很会骗人的烂桃花。时间会证明一切该留在谁身边。","all":"80","resultcode":"200","error_code":0}
     * week : {"name":"狮子座","weekth":22,"date":"2020年05月24日-2020年05月30日","health":"","job":"学业：本周学业方面自己对目前的状态不是很满意，想追求新的进步，要注意周边的一些机会，不要错失良机哦。","love":"恋爱：本周感情运佳，单身者可能会遇到非常亲切随和的异性朋友，有责任心而且有胆识，非常值得信赖的一个人。有伴者会因为彼此的社会地位头衔，收入这类客观条件不平等，差距较大，因为没有安全感而争吵。","money":"财运：本周财运较好，赚钱的欲望不足，但是还是有金钱不断的流入，自己更多的心思会放到家庭上面。有副业方面的狮子座，能够通过之前的老客户转介绍给自己一些赚钱的资源。","work":"工作：本周事业运一般，工作上有些漫不经心，没自信，时常怀疑自己的能力，遇到事情容易拖延，没太有责任心。求职者运气不错，能够在面试中因为优秀的自身能力而意外获得更加收入颇丰的好岗位。","resultcode":"200","error_code":0}
     * nextweek : {"name":"狮子座","weekth":23,"date":"2020年05月24日-2020年05月30日","health":"","job":"学业：本周的学业运势一般。作为学生党的狮子座可能会在某一些问题上和老师没有办法统一意见，但是这并没有什么大碍，好好沟通就会解决问题，老师也会帮助你。","love":"恋爱：爱情运势在本周会有所回转，单身的狮子座在本周桃花不错，可以适当的参加一些集体活动，说不定会有火花产生，有伴的狮子座要学着对对方表现出自己柔软的一面，心事要及时地吐露给自己的伴侣，同时也要多倾听一下自己伴侣的心声，这样，两个人的感情才会升温。","money":"财运：本周的财运运势偏上，正财和偏财运都不一般，不适合大额的开销，生活上会有一些琐碎的东西，因为破损或要及时的更换而产生之初，建议自己要多关注健康问题，可能会因为健康而产生一些医药方面的开支。","work":"工作：本周狮子座的工作运势不错，适合闷声发大财，处理事情的时候要更加的仔细谨慎。注意，在人际交往方面，不要和一些别有用心的人针锋相对，对于一些恶意的揣测和评价，不要放在心上，更不要去辩解，建议在本周要学会积累一些工作经验来夯实自己相关的知识，为以后的发展打下基础。","resultcode":"200","error_code":0}
     * month : {"date":"2020年05月","name":"狮子座","month":5,"health":"健康：部分狮子座会因为身体不适，可能会去医院预约检查。","all":"总运势：狮子座的整体运势较好，在生活中要学会自我控制和勉励，再接再厉，能够得到更好的收获。","love":"感情运：单身的狮子座希望他人能够理解和喜欢他们的小个性，有伴的狮子座则会改正自己过于强势的问题。","money":"财运：财运稳中有涨，但是主要来源于正财方面，工作上的刻苦努力能够得到加薪的收获，部分狮子座还会得到兼职的机会，但是在投资理财方面本月运势一般，不可过分投入。","work":"工作运：事业运势尚可，对于工作的热情持续高涨，工作效率较高，工作表现也能够得到上司和同事的认可，在事业的进阶上本月可说有一个顺风之势，如果能够及时缓解自我的工作压力会得到更大的成功。","happyMagic":"","resultcode":"200","error_code":0}
     * year : {"name":"狮子座","date":"2020年","year":2020,"mima":{"info":"学会察言观色","text":["2020年，狮子座要学会的就是管理好自己的情绪。你们其实是很容易就被情绪牵着鼻子走的，而2020年整体相对压抑克制的环境很可能就会带给你们在情绪方面的压力和困扰。除此之外，在2020年，狮子座切记不要急躁，不管是面对机会还是身处于竞争中，都要冷静沉稳的处理。因为这一年主要的基调就是克制，所以急躁冒进地处理问题往往很难得到结果。还有，狮子座在这一年里要学会向他人请教，经验也好，技巧也好，这会让你在做事情的时候少走很多弯路。"]},"career":["事业上，在今年狮子要在离职或者跳槽之前想清楚自己离职的原因是什么，不要只是因为简单的情绪问题就贸然离职。此外，这一年在职场上要处理好人际关系，不要给自己树敌，在公共场合发言时也要注意不要带有太浓厚的主观色彩。学业上，狮子座在这一年里最重要的就是踏实，不管学习什么知识，都要一步一个脚印的夯实基础，不要好高骛远或者是舍本逐末。"],"love":["整年来看，狮子座的爱情运势比较平稳，不会有太多的波折和坎坷。单身的狮子在遇到合适的对象时可以尝试着交往，因为这一年的大环境影响，你遇到的人多半都是比较踏实靠谱的。不过，在公开场合还是要收敛一下自己的情绪，以免给对你心存想法的人留下不够稳重的坏印象。有伴的狮子，今年要着重注意处理和另一半的摩擦，在和对方相处的时候要学会包容和珍惜，放下脸面平息摩擦并不是一件坏事。"],"health":["学业方面，狮子座2020年度的状态，比2019年要好。学习状态积极，只是压力大，需要付出加倍努力，才能获得好的成绩。尤其是10月-11月期间，某些狮子座可能会因为家庭原因，导致学业方面不顺利。健康方面，狮子座在2020年要特别留意，背部，脊柱，牙齿，左耳，心脏，心脑血管，牙齿，皮肤等方面病痛出现。"],"finance":["今年狮子座的健康运势良好，要注意不要酗酒或者是熬夜，在生活作息上保持规律。此外，在运动之前要做好保护措施，防止肌肉拉伤或者运动扭伤。"],"luckeyStone":"美国碧玉","future":"","resultcode":"200","error_code":0}
     */

    private String resultcode;
    private int error_code;
    private TodayBean today;
    private TomorrowBean tomorrow;
    private WeekBean week;
    private NextweekBean nextweek;
    private MonthBean month;
    private YearBean year;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public TodayBean getToday() {
        return today;
    }

    public void setToday(TodayBean today) {
        this.today = today;
    }

    public TomorrowBean getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(TomorrowBean tomorrow) {
        this.tomorrow = tomorrow;
    }

    public WeekBean getWeek() {
        return week;
    }

    public void setWeek(WeekBean week) {
        this.week = week;
    }

    public NextweekBean getNextweek() {
        return nextweek;
    }

    public void setNextweek(NextweekBean nextweek) {
        this.nextweek = nextweek;
    }

    public MonthBean getMonth() {
        return month;
    }

    public void setMonth(MonthBean month) {
        this.month = month;
    }

    public YearBean getYear() {
        return year;
    }

    public void setYear(YearBean year) {
        this.year = year;
    }

    public static class TodayBean {
        /**
         * date : 20200528
         * name : 狮子座
         * QFriend : 射手座
         * color : 绿色
         * datetime : 2020年05月28日
         * health : 60
         * love : 70
         * work : 70
         * money : 60
         * number : 8
         * summary : 今天的狮子宝宝们会发现人际关系一度陷入紧张状态，自己已经一改平日的强势风格，变得善解人意，但对方依旧不依不饶，让你很头疼。今天也是犯烂桃花和三角恋的一天，今天也是你施展魅力的一天。
         * all : 75
         * resultcode : 200
         * error_code : 0
         */

        private int date;
        private String name;
        private String QFriend;
        private String color;
        private String datetime;
        private String health;
        private String love;
        private String work;
        private String money;
        private int number;
        private String summary;
        private String all;
        private String resultcode;
        private int error_code;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQFriend() {
            return QFriend;
        }

        public void setQFriend(String QFriend) {
            this.QFriend = QFriend;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
    }

    public static class TomorrowBean {
        /**
         * date : 20200529
         * name : 狮子座
         * QFriend : 摩羯座
         * color : 黑色
         * datetime : 2020年05月29日
         * health : 70
         * love : 70
         * work : 70
         * money : 80
         * number : 1
         * summary : 今天有伴儿的狮子宝宝们会觉得另一半特别不近人情，会因僵硬的关系而影响心情。同时部分狮子宝宝也会出现挖墙脚的人，一定不能动摇哦，对方是很会骗人的烂桃花。时间会证明一切该留在谁身边。
         * all : 80
         * resultcode : 200
         * error_code : 0
         */

        private int date;
        private String name;
        private String QFriend;
        private String color;
        private String datetime;
        private String health;
        private String love;
        private String work;
        private String money;
        private int number;
        private String summary;
        private String all;
        private String resultcode;
        private int error_code;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQFriend() {
            return QFriend;
        }

        public void setQFriend(String QFriend) {
            this.QFriend = QFriend;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
    }

    public static class WeekBean {
        /**
         * name : 狮子座
         * weekth : 22
         * date : 2020年05月24日-2020年05月30日
         * health :
         * job : 学业：本周学业方面自己对目前的状态不是很满意，想追求新的进步，要注意周边的一些机会，不要错失良机哦。
         * love : 恋爱：本周感情运佳，单身者可能会遇到非常亲切随和的异性朋友，有责任心而且有胆识，非常值得信赖的一个人。有伴者会因为彼此的社会地位头衔，收入这类客观条件不平等，差距较大，因为没有安全感而争吵。
         * money : 财运：本周财运较好，赚钱的欲望不足，但是还是有金钱不断的流入，自己更多的心思会放到家庭上面。有副业方面的狮子座，能够通过之前的老客户转介绍给自己一些赚钱的资源。
         * work : 工作：本周事业运一般，工作上有些漫不经心，没自信，时常怀疑自己的能力，遇到事情容易拖延，没太有责任心。求职者运气不错，能够在面试中因为优秀的自身能力而意外获得更加收入颇丰的好岗位。
         * resultcode : 200
         * error_code : 0
         */

        private String name;
        private int weekth;
        private String date;
        private String health;
        private String job;
        private String love;
        private String money;
        private String work;
        private String resultcode;
        private int error_code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeekth() {
            return weekth;
        }

        public void setWeekth(int weekth) {
            this.weekth = weekth;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
    }

    public static class NextweekBean {
        /**
         * name : 狮子座
         * weekth : 23
         * date : 2020年05月24日-2020年05月30日
         * health :
         * job : 学业：本周的学业运势一般。作为学生党的狮子座可能会在某一些问题上和老师没有办法统一意见，但是这并没有什么大碍，好好沟通就会解决问题，老师也会帮助你。
         * love : 恋爱：爱情运势在本周会有所回转，单身的狮子座在本周桃花不错，可以适当的参加一些集体活动，说不定会有火花产生，有伴的狮子座要学着对对方表现出自己柔软的一面，心事要及时地吐露给自己的伴侣，同时也要多倾听一下自己伴侣的心声，这样，两个人的感情才会升温。
         * money : 财运：本周的财运运势偏上，正财和偏财运都不一般，不适合大额的开销，生活上会有一些琐碎的东西，因为破损或要及时的更换而产生之初，建议自己要多关注健康问题，可能会因为健康而产生一些医药方面的开支。
         * work : 工作：本周狮子座的工作运势不错，适合闷声发大财，处理事情的时候要更加的仔细谨慎。注意，在人际交往方面，不要和一些别有用心的人针锋相对，对于一些恶意的揣测和评价，不要放在心上，更不要去辩解，建议在本周要学会积累一些工作经验来夯实自己相关的知识，为以后的发展打下基础。
         * resultcode : 200
         * error_code : 0
         */

        private String name;
        private int weekth;
        private String date;
        private String health;
        private String job;
        private String love;
        private String money;
        private String work;
        private String resultcode;
        private int error_code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeekth() {
            return weekth;
        }

        public void setWeekth(int weekth) {
            this.weekth = weekth;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
    }

    public static class MonthBean {
        /**
         * date : 2020年05月
         * name : 狮子座
         * month : 5
         * health : 健康：部分狮子座会因为身体不适，可能会去医院预约检查。
         * all : 总运势：狮子座的整体运势较好，在生活中要学会自我控制和勉励，再接再厉，能够得到更好的收获。
         * love : 感情运：单身的狮子座希望他人能够理解和喜欢他们的小个性，有伴的狮子座则会改正自己过于强势的问题。
         * money : 财运：财运稳中有涨，但是主要来源于正财方面，工作上的刻苦努力能够得到加薪的收获，部分狮子座还会得到兼职的机会，但是在投资理财方面本月运势一般，不可过分投入。
         * work : 工作运：事业运势尚可，对于工作的热情持续高涨，工作效率较高，工作表现也能够得到上司和同事的认可，在事业的进阶上本月可说有一个顺风之势，如果能够及时缓解自我的工作压力会得到更大的成功。
         * happyMagic :
         * resultcode : 200
         * error_code : 0
         */

        private String date;
        private String name;
        private int month;
        private String health;
        private String all;
        private String love;
        private String money;
        private String work;
        private String happyMagic;
        private String resultcode;
        private int error_code;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public String getHappyMagic() {
            return happyMagic;
        }

        public void setHappyMagic(String happyMagic) {
            this.happyMagic = happyMagic;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
    }

    public static class YearBean {
        /**
         * name : 狮子座
         * date : 2020年
         * year : 2020
         * mima : {"info":"学会察言观色","text":["2020年，狮子座要学会的就是管理好自己的情绪。你们其实是很容易就被情绪牵着鼻子走的，而2020年整体相对压抑克制的环境很可能就会带给你们在情绪方面的压力和困扰。除此之外，在2020年，狮子座切记不要急躁，不管是面对机会还是身处于竞争中，都要冷静沉稳的处理。因为这一年主要的基调就是克制，所以急躁冒进地处理问题往往很难得到结果。还有，狮子座在这一年里要学会向他人请教，经验也好，技巧也好，这会让你在做事情的时候少走很多弯路。"]}
         * career : ["事业上，在今年狮子要在离职或者跳槽之前想清楚自己离职的原因是什么，不要只是因为简单的情绪问题就贸然离职。此外，这一年在职场上要处理好人际关系，不要给自己树敌，在公共场合发言时也要注意不要带有太浓厚的主观色彩。学业上，狮子座在这一年里最重要的就是踏实，不管学习什么知识，都要一步一个脚印的夯实基础，不要好高骛远或者是舍本逐末。"]
         * love : ["整年来看，狮子座的爱情运势比较平稳，不会有太多的波折和坎坷。单身的狮子在遇到合适的对象时可以尝试着交往，因为这一年的大环境影响，你遇到的人多半都是比较踏实靠谱的。不过，在公开场合还是要收敛一下自己的情绪，以免给对你心存想法的人留下不够稳重的坏印象。有伴的狮子，今年要着重注意处理和另一半的摩擦，在和对方相处的时候要学会包容和珍惜，放下脸面平息摩擦并不是一件坏事。"]
         * health : ["学业方面，狮子座2020年度的状态，比2019年要好。学习状态积极，只是压力大，需要付出加倍努力，才能获得好的成绩。尤其是10月-11月期间，某些狮子座可能会因为家庭原因，导致学业方面不顺利。健康方面，狮子座在2020年要特别留意，背部，脊柱，牙齿，左耳，心脏，心脑血管，牙齿，皮肤等方面病痛出现。"]
         * finance : ["今年狮子座的健康运势良好，要注意不要酗酒或者是熬夜，在生活作息上保持规律。此外，在运动之前要做好保护措施，防止肌肉拉伤或者运动扭伤。"]
         * luckeyStone : 美国碧玉
         * future :
         * resultcode : 200
         * error_code : 0
         */

        private String name;
        private String date;
        private int year;
        private MimaBean mima;
        private String luckeyStone;
        private String future;
        private String resultcode;
        private int error_code;
        private List<String> career;
        private List<String> love;
        private List<String> health;
        private List<String> finance;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public MimaBean getMima() {
            return mima;
        }

        public void setMima(MimaBean mima) {
            this.mima = mima;
        }

        public String getLuckeyStone() {
            return luckeyStone;
        }

        public void setLuckeyStone(String luckeyStone) {
            this.luckeyStone = luckeyStone;
        }

        public String getFuture() {
            return future;
        }

        public void setFuture(String future) {
            this.future = future;
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public List<String> getCareer() {
            return career;
        }

        public void setCareer(List<String> career) {
            this.career = career;
        }

        public List<String> getLove() {
            return love;
        }

        public void setLove(List<String> love) {
            this.love = love;
        }

        public List<String> getHealth() {
            return health;
        }

        public void setHealth(List<String> health) {
            this.health = health;
        }

        public List<String> getFinance() {
            return finance;
        }

        public void setFinance(List<String> finance) {
            this.finance = finance;
        }

        public static class MimaBean {
            /**
             * info : 学会察言观色
             * text : ["2020年，狮子座要学会的就是管理好自己的情绪。你们其实是很容易就被情绪牵着鼻子走的，而2020年整体相对压抑克制的环境很可能就会带给你们在情绪方面的压力和困扰。除此之外，在2020年，狮子座切记不要急躁，不管是面对机会还是身处于竞争中，都要冷静沉稳的处理。因为这一年主要的基调就是克制，所以急躁冒进地处理问题往往很难得到结果。还有，狮子座在这一年里要学会向他人请教，经验也好，技巧也好，这会让你在做事情的时候少走很多弯路。"]
             */

            private String info;
            private List<String> text;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public List<String> getText() {
                return text;
            }

            public void setText(List<String> text) {
                this.text = text;
            }
        }
    }
}
