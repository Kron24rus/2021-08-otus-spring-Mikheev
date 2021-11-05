(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[4],{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/GenreList.vue?vue&type=script&lang=js":
/*!*******************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/GenreList.vue?vue&type=script&lang=js ***!
  \*******************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _services_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../services/api-service */ \"./src/services/api-service.js\");\n\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  name: \"GenreList\",\n  data: function data() {\n    return {\n      genres: null\n    };\n  },\n  mounted: function mounted() {\n    this.getGenreList();\n  },\n  methods: {\n    getGenreList: function getGenreList() {\n      var that = this;\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].getGenreList().then(function (response) {\n        that.genres = response.data;\n      })[\"catch\"](function (error) {//todo: add error message\n      });\n    }\n  }\n});\n\n//# sourceURL=webpack:///./src/views/GenreList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/GenreList.vue?vue&type=template&id=3b859912":
/*!**************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/GenreList.vue?vue&type=template&id=3b859912 ***!
  \**************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return render; });\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! core-js/modules/es.function.name.js */ \"./node_modules/core-js/modules/es.function.name.js\");\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var vue__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! vue */ \"./node_modules/vue/dist/vue.runtime.esm-bundler.js\");\n\n\nvar _hoisted_1 = {\n  \"class\": \"col-12\"\n};\n\nvar _hoisted_2 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"h1\", null, \"Genres:\", -1\n/* HOISTED */\n);\n\nvar _hoisted_3 = {\n  \"class\": \"table\"\n};\n\nvar _hoisted_4 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"thead\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"tr\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"th\", null, \"ID\"), /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"th\", null, \"Title\")])], -1\n/* HOISTED */\n);\n\nfunction render(_ctx, _cache, $props, $setup, $data, $options) {\n  return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"div\", _hoisted_1, [_hoisted_2, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"table\", _hoisted_3, [_hoisted_4, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"tbody\", null, [(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(true), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(vue__WEBPACK_IMPORTED_MODULE_1__[\"Fragment\"], null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"renderList\"])(_ctx.genres, function (genre, index) {\n    return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"tr\", {\n      key: index\n    }, [Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(genre.id), 1\n    /* TEXT */\n    ), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(genre.name), 1\n    /* TEXT */\n    )]);\n  }), 128\n  /* KEYED_FRAGMENT */\n  ))])])]);\n}\n\n//# sourceURL=webpack:///./src/views/GenreList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./src/views/GenreList.vue":
/*!*********************************!*\
  !*** ./src/views/GenreList.vue ***!
  \*********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _GenreList_vue_vue_type_template_id_3b859912__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./GenreList.vue?vue&type=template&id=3b859912 */ \"./src/views/GenreList.vue?vue&type=template&id=3b859912\");\n/* harmony import */ var _GenreList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./GenreList.vue?vue&type=script&lang=js */ \"./src/views/GenreList.vue?vue&type=script&lang=js\");\n/* empty/unused harmony star reexport *//* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/vue-loader-v16/dist/exportHelper.js */ \"./node_modules/vue-loader-v16/dist/exportHelper.js\");\n/* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__);\n\n\n\n\n\nconst __exports__ = /*#__PURE__*/D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default()(_GenreList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"], [['render',_GenreList_vue_vue_type_template_id_3b859912__WEBPACK_IMPORTED_MODULE_0__[\"render\"]],['__file',\"src/views/GenreList.vue\"]])\n/* hot reload */\nif (false) {}\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = (__exports__);\n\n//# sourceURL=webpack:///./src/views/GenreList.vue?");

/***/ }),

/***/ "./src/views/GenreList.vue?vue&type=script&lang=js":
/*!*********************************************************!*\
  !*** ./src/views/GenreList.vue?vue&type=script&lang=js ***!
  \*********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_GenreList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./GenreList.vue?vue&type=script&lang=js */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/GenreList.vue?vue&type=script&lang=js\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"default\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_GenreList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"]; });\n\n/* empty/unused harmony star reexport */ \n\n//# sourceURL=webpack:///./src/views/GenreList.vue?");

/***/ }),

/***/ "./src/views/GenreList.vue?vue&type=template&id=3b859912":
/*!***************************************************************!*\
  !*** ./src/views/GenreList.vue?vue&type=template&id=3b859912 ***!
  \***************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_GenreList_vue_vue_type_template_id_3b859912__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./GenreList.vue?vue&type=template&id=3b859912 */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/GenreList.vue?vue&type=template&id=3b859912\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_GenreList_vue_vue_type_template_id_3b859912__WEBPACK_IMPORTED_MODULE_0__[\"render\"]; });\n\n\n\n//# sourceURL=webpack:///./src/views/GenreList.vue?");

/***/ })

}]);