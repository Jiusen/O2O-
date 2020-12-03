/**
 * 
 */
$(function() {
	// 用于店铺注册时候的店铺类别以及区域列表的初始化的URL
	var initUrl = '/schoolo2o/shopmanagement/getshopinitinfo';
	// 注册店铺的URL
	var registerShopUrl = '/schoolo2o/shopmanagement/registershop';

	getShopInitInfo();

	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			console.log(data);
			if (data != null) {  //if (data.success)
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId
						+ '">' + item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
						+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}
})