var comn;
comn = {};
!function (t) {
    t.fn.values = function (e) {
        var i = t(this).find(":input").get();
        return "object" != typeof e ? (e = {}, t.each(i, function () {
            this.name && !this.disabled && (this.checked || /select|textarea/i.test(this.nodeName) || /text|hidden|password/i.test(this.type)) && (e[this.name] = t(this).val())
        }), e) : (t.each(i, function () {
            this.name && e[this.name] + "" && "undefined" != typeof e[this.name] && ("checkbox" == this.type || "radio" == this.type ? t(this).prop("checked", e[this.name] == t(this).val()) : t(this).val(e[this.name]))
        }), t(this))
    }
}(jQuery);

(function() {
	  tip = function(o) {
	    var base;
	    return typeof (base = window.parent.comn).tip === "function" ? base.tip(o) : void 0;
	  };
	  return comn = {
	    ajax: function(o) {
	      var _this, mask;
	      mask = layer.load(2);
	      _this = this;
	      if (o.url) {
	        return $.ajax({
	          url: o.url,
	          type: o.type || "POST",
	          dataType: "json",
	          async: o.async || true,
	          data: o.data || {},
	          complete: function(jqXHR, textStatus) {
	            return layer.close(mask);
	          },
	          success: function(data) {
	            if (data.code === 20000) {
	              return tip({
	                content: data.message || "<code>" + o.url + "</code><br /> 接口异常！！！"
	              });
	            } else if (data.code === 30000) {
	              return window.parent.location.href = "../../../index.html";
	            } else {
	              if (typeof data === "string") {
	                data = JSON.parse(data);
	              }
	              return typeof o.success === "function" ? o.success(data) : void 0;
	            }
	          },
	          error: function(jqXHR, textStatus, errorThrown) {
	            return typeof o.error === "function" ? o.error(textStatus) : void 0;
	          }
	        });
	      }
	    }
	  };
	})();
comn.ajax({
  url: "/test/t1",
  success: function(res){
	  console.log(res.data);
	  $("#customerCreditParamInfo").values(res.data);
  }
});
