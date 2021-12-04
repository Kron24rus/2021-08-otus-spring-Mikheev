(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[2],{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/AuthorList.vue?vue&type=script&lang=js":
/*!********************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/AuthorList.vue?vue&type=script&lang=js ***!
  \********************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _services_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../services/api-service */ \"./src/services/api-service.js\");\n\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  name: \"AuthorList\",\n  data: function data() {\n    return {\n      authors: null\n    };\n  },\n  mounted: function mounted() {\n    this.getAuthorList();\n  },\n  methods: {\n    getAuthorList: function getAuthorList() {\n      var _this = this;\n\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].getAuthorList().then(function (response) {\n        _this.authors = response.data;\n      })[\"catch\"](function (error) {//todo: add error message\n      });\n    }\n  }\n});\n\n//# sourceURL=webpack:///./src/views/AuthorList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/AuthorList.vue?vue&type=template&id=192d2e03":
/*!***************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/AuthorList.vue?vue&type=template&id=192d2e03 ***!
  \***************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return render; });\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! core-js/modules/es.function.name.js */ \"./node_modules/core-js/modules/es.function.name.js\");\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var vue__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! vue */ \"./node_modules/vue/dist/vue.runtime.esm-bundler.js\");\n\n\nvar _hoisted_1 = {\n  \"class\": \"col-12\"\n};\n\nvar _hoisted_2 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"h1\", null, \"Authors\", -1\n/* HOISTED */\n);\n\nvar _hoisted_3 = {\n  \"class\": \"table\"\n};\n\nvar _hoisted_4 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"thead\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"tr\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"th\", null, \"ID\"), /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"th\", null, \"Title\")])], -1\n/* HOISTED */\n);\n\nfunction render(_ctx, _cache, $props, $setup, $data, $options) {\n  return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"div\", _hoisted_1, [_hoisted_2, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"table\", _hoisted_3, [_hoisted_4, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"tbody\", null, [(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(true), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(vue__WEBPACK_IMPORTED_MODULE_1__[\"Fragment\"], null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"renderList\"])(_ctx.authors, function (author, index) {\n    return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"tr\", {\n      key: index\n    }, [Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(author.id), 1\n    /* TEXT */\n    ), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(author.name), 1\n    /* TEXT */\n    )]);\n  }), 128\n  /* KEYED_FRAGMENT */\n  ))])])]);\n}\n\n//# sourceURL=webpack:///./src/views/AuthorList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/core-js/modules/es.function.name.js":
/*!**********************************************************!*\
  !*** ./node_modules/core-js/modules/es.function.name.js ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("var DESCRIPTORS = __webpack_require__(/*! ../internals/descriptors */ \"./node_modules/core-js/internals/descriptors.js\");\nvar FUNCTION_NAME_EXISTS = __webpack_require__(/*! ../internals/function-name */ \"./node_modules/core-js/internals/function-name.js\").EXISTS;\nvar uncurryThis = __webpack_require__(/*! ../internals/function-uncurry-this */ \"./node_modules/core-js/internals/function-uncurry-this.js\");\nvar defineProperty = __webpack_require__(/*! ../internals/object-define-property */ \"./node_modules/core-js/internals/object-define-property.js\").f;\n\nvar FunctionPrototype = Function.prototype;\nvar functionToString = uncurryThis(FunctionPrototype.toString);\nvar nameRE = /^\\s*function ([^ (]*)/;\nvar regExpExec = uncurryThis(nameRE.exec);\nvar NAME = 'name';\n\n// Function instances `.name` property\n// https://tc39.es/ecma262/#sec-function-instances-name\nif (DESCRIPTORS && !FUNCTION_NAME_EXISTS) {\n  defineProperty(FunctionPrototype, NAME, {\n    configurable: true,\n    get: function () {\n      try {\n        return regExpExec(nameRE, functionToString(this))[1];\n      } catch (error) {\n        return '';\n      }\n    }\n  });\n}\n\n\n//# sourceURL=webpack:///./node_modules/core-js/modules/es.function.name.js?");

/***/ }),

/***/ "./src/services/api-service.js":
/*!*************************************!*\
  !*** ./src/services/api-service.js ***!
  \*************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! axios */ \"./node_modules/axios/index.js\");\n/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(axios__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var _auth_header__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./auth-header */ \"./src/services/auth-header.js\");\n\n\nvar apiClient = axios__WEBPACK_IMPORTED_MODULE_0___default.a.create({\n  baseURL: '/api/library',\n  withCredentials: false\n});\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  getBookList: function getBookList() {\n    return apiClient.get('/book', {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  getBook: function getBook(bookId) {\n    return apiClient.get(\"/book/\".concat(bookId), {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  deleteBook: function deleteBook(bookId) {\n    return apiClient[\"delete\"](\"/book/\".concat(bookId), {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  getAuthorList: function getAuthorList() {\n    return apiClient.get('/author', {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  getGenreList: function getGenreList() {\n    return apiClient.get('/genre', {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  getEditLibraryEntities: function getEditLibraryEntities() {\n    return apiClient.get('/associations', {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  saveUpdatedBook: function saveUpdatedBook(data) {\n    return apiClient.put('/book', data, {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  addBook: function addBook(data) {\n    return apiClient.post('/book', data, {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  addComment: function addComment(data) {\n    return apiClient.post('/comment', data, {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  saveUpdatedComment: function saveUpdatedComment(data) {\n    return apiClient.put('/comment', data, {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  },\n  deleteComment: function deleteComment(commentId) {\n    return apiClient[\"delete\"](\"/comment/\".concat(commentId), {\n      headers: Object(_auth_header__WEBPACK_IMPORTED_MODULE_1__[\"default\"])()\n    });\n  }\n});\n\n//# sourceURL=webpack:///./src/services/api-service.js?");

/***/ }),

/***/ "./src/services/auth-header.js":
/*!*************************************!*\
  !*** ./src/services/auth-header.js ***!
  \*************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"default\", function() { return authHeader; });\nfunction authHeader() {\n  var user = JSON.parse(localStorage.getItem('user'));\n\n  if (user && user.accessToken) {\n    return {\n      'Content-Type': 'application/json',\n      'Authorization': 'Bearer ' + user.accessToken\n    };\n  } else {\n    return {\n      'Content-Type': 'application/json'\n    };\n  }\n}\n\n//# sourceURL=webpack:///./src/services/auth-header.js?");

/***/ }),

/***/ "./src/views/AuthorList.vue":
/*!**********************************!*\
  !*** ./src/views/AuthorList.vue ***!
  \**********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _AuthorList_vue_vue_type_template_id_192d2e03__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./AuthorList.vue?vue&type=template&id=192d2e03 */ \"./src/views/AuthorList.vue?vue&type=template&id=192d2e03\");\n/* harmony import */ var _AuthorList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./AuthorList.vue?vue&type=script&lang=js */ \"./src/views/AuthorList.vue?vue&type=script&lang=js\");\n/* empty/unused harmony star reexport *//* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/vue-loader-v16/dist/exportHelper.js */ \"./node_modules/vue-loader-v16/dist/exportHelper.js\");\n/* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__);\n\n\n\n\n\nconst __exports__ = /*#__PURE__*/D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default()(_AuthorList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"], [['render',_AuthorList_vue_vue_type_template_id_192d2e03__WEBPACK_IMPORTED_MODULE_0__[\"render\"]],['__file',\"src/views/AuthorList.vue\"]])\n/* hot reload */\nif (false) {}\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = (__exports__);\n\n//# sourceURL=webpack:///./src/views/AuthorList.vue?");

/***/ }),

/***/ "./src/views/AuthorList.vue?vue&type=script&lang=js":
/*!**********************************************************!*\
  !*** ./src/views/AuthorList.vue?vue&type=script&lang=js ***!
  \**********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_AuthorList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./AuthorList.vue?vue&type=script&lang=js */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/AuthorList.vue?vue&type=script&lang=js\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"default\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_AuthorList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"]; });\n\n/* empty/unused harmony star reexport */ \n\n//# sourceURL=webpack:///./src/views/AuthorList.vue?");

/***/ }),

/***/ "./src/views/AuthorList.vue?vue&type=template&id=192d2e03":
/*!****************************************************************!*\
  !*** ./src/views/AuthorList.vue?vue&type=template&id=192d2e03 ***!
  \****************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_AuthorList_vue_vue_type_template_id_192d2e03__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./AuthorList.vue?vue&type=template&id=192d2e03 */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/AuthorList.vue?vue&type=template&id=192d2e03\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_AuthorList_vue_vue_type_template_id_192d2e03__WEBPACK_IMPORTED_MODULE_0__[\"render\"]; });\n\n\n\n//# sourceURL=webpack:///./src/views/AuthorList.vue?");

/***/ })

}]);