new Vue({
    el: '#addTaskDiv',

    data: {

        keyWords: '',
        goodsLink: '',

        payCount: false,
        payMinCount: 0,
        payMaxCount: 0,

        sortType: '综合排序',
        start_price: 0,
        end_price: 0,
        loc: '所有地区',

        collectRate: 0,
        addShopcartRate: 0,

        sortTypeOptions: [
            {text: "综合排序", value: "综合排序"},
            {text: "销量优先", value: "销量优先"},
            {text: "价格从低到高", value: "价格从低到高"},
            {text: "价格从高到低", value: "价格从高到低"},
            {text: "信用排序", value: "信用排序"}
        ],
        sortTypeSelected: "综合排序",

        searchAreaOptions: [
            {text: "所有地区", value: "所有地区"},
            {text: "江浙沪", value: "江浙沪"},
            {text: "珠三角", value: "珠三角"},
            {text: "港澳台", value: "港澳台"},
            {text: "海外", value: "海外"},
            {text: "北京", value: "北京"},
            {text: "上海", value: "上海"},
            {text: "广州", value: "广州"},
            {text: "深圳", value: "深圳"},
            {text: "杭州", value: "杭州"}
        ],
        searchAreaSelected: "所有地区",


        priceRangeChecked: false,
        priceRangeMinValue: 0,
        priceRangeMaxValue: 0,

        searchGoodsBrowseMinTimeOptions: [
            {text: "5", value: "5"},
            {text: "10", value: "10"},
            {text: "60", value: "60"},
            {text: "120", value: "120"}
        ],
        searchGoodsBrowseMinTimeSelected: 60,

        searchGoodsBrowseMaxTimeOptions: [
            {text: "5", value: "5"},
            {text: "10", value: "10"},
            {text: "60", value: "60"},
            {text: "120", value: "120"}
        ],
        searchGoodsBrowseMaxTimeSelected: 120,

        otherGoodsBrowseMinTimeOptions: [
            {text: "5", value: "5"},
            {text: "10", value: "10"},
            {text: "60", value: "60"},
            {text: "120", value: "120"}
        ],
        otherGoodsBrowseMinTimeSelected: 10,

        otherGoodsBrowseMaxTimeOptions: [
            {text: "5", value: "5"},
            {text: "10", value: "10"},
            {text: "60", value: "60"},
            {text: "120", value: "120"}
        ],
        otherGoodsBrowseMaxTimeSelected: 60,

        otherGoodsBrowseMinCountOptions: [
            {text: "1", value: "1"},
            {text: "2", value: "2"}
        ],
        otherGoodsBrowseMinCountSelected: 1,

        otherGoodsBrowseMaxCountOptions: [
            {text: "1", value: "1"},
            {text: "2", value: "2"}
        ],
        otherGoodsBrowseMaxCountSelected: 2,

        accessOtherShopMinCountOptions: [
            {text: "0", value: "0"},
            {text: "1", value: "1"},
            {text: "2", value: "2"},
            {text: "3", value: "3"},
            {text: "4", value: "4"},
            {text: "5", value: "5"}
        ],
        accessOtherShopMinCountSelected: 1,

        accessOtherShopMaxCountOptions: [
            {text: "0", value: "0"},
            {text: "1", value: "1"},
            {text: "2", value: "2"},
            {text: "3", value: "3"},
            {text: "4", value: "4"},
            {text: "5", value: "5"}
        ],
        accessOtherShopMaxCountSelected: 3,

        memo: "",

        myfChecked: false,
        tmChecked: false,
        sjzxChecked: false,
        tjbChecked: false,
        hdfkChecked: false,
        cxChecked: false,

        collectGoods: true,
        onlyShow: false,
        clickGoodsParam: true,
        clickShopMainPage: false,
        clickShopCommentRecord: true,
        zhiTongChe: false,

        taskCount: 1,

        hourCounts: [
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0
        ],

        taskCountSelected: 1,
    },

    computed: {
        heji: function () {
            return this.danjia * this.geshu
        },

        geshu: function () {
            return this.taskCount
        },

        danjia: function () {
            return 10 + Math.ceil(parseInt(this.collectRate) / 10 ) + Math.ceil(parseInt(this.addShopcartRate) / 10 )
        }
    },

    ready: function () {
        this.taskInit();
    },

    methods: {
/*
        inputBlur: function (count) {

            for (var sum = i = 0; i < this.hourCounts.length; i++) {
                if(this.hourCounts[i] == "") (this.hourCounts[i] = 0);
                sum += parseInt(this.hourCounts[i]);
            };

            if (sum == 0) {
                sum = 1;
                this.calculatePoints();
            }

            this.taskCount = sum;

        },
*/
        taskInit: function () {
            var myDate = new Date();
            var startHours = myDate.getHours();

            var taskCounts = [
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0
            ];

            taskCounts[startHours] = 1;

            this.hourCounts = taskCounts;

        },

        calculatePoints: function () {

            var myDate = new Date();
            var startHours = myDate.getHours();

            var taskCounts = [
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0
            ];

            var j = startHours;

            for (var i = 0; i < this.taskCount; i++) {
                taskCounts[j] = taskCounts[j] + 1;
                j > 22 ? j = startHours : j++;
            }


            this.hourCounts = taskCounts;
        },

        searchOrder: function () {

            var fillter = {
                service_myf: this.myfChecked,
                tab_mall: this.tmChecked,
                service_tjb: this.tjbChecked,
                tab_discount: this.cxChecked,
                service_sjzx: this.sjzxChecked,
                service_hdfk: this.hdfkChecked
            }

            if (this.goodsLink == '' || this.keyWords == '') {
                this.sweetAlert();
            } else {
                $("#searchOrderInnerWrapper").children().remove();
                for (var i = 0; i < 8; i++) {
                    this.ajaxSearch(this.goodsLink, this.keyWords, fillter, this.start_price, this.end_price, this.loc, this.sortType)
                }
            }

        },

        ajaxSearch: function (url, keyword, fillter, start_price, end_price, loc, sortOrder) {

            $.post('/ajax/getKeyWordsOrder', {
                param: url,
                keyWord: keyword,
                query: {filter: fillter, start_price: start_price, end_price: end_price, loc: loc, sortOrder: sortOrder}
            }, function (searchData) {

                if (searchData.page == 0) {
                    $('#searchOrderInnerWrapper').append('<button type="button" disabled class="form_btn_order_notfound">' + '未找到' + '</button>');
                    return;
                }

                if (searchData.page <= 5) {
                    $('#searchOrderInnerWrapper').append('<button type="button" disabled class="form_btn_order_good">' + searchData.page + '页' + searchData.order + '位' + '</button>');
                    return;
                }

                if (searchData.page > 5) {
                    $('#searchOrderInnerWrapper').append('<button type="button" disabled class="form_btn_order_bad">' + searchData.page + '页' + searchData.order + '位' + '</button>');
                    return;
                }
            })
        },

        sweetAlert: function () {
            swal({title: '错误', text: '宝贝链接和关键字不能为空', type: 'error', timer: 1700, showConfirmButton: false});
        }

    }

});