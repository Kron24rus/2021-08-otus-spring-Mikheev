(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[2],{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/components/book/BookAdd.vue?vue&type=script&lang=js":
/*!***************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/components/book/BookAdd.vue?vue&type=script&lang=js ***!
  \***************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _services_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @/services/api-service */ \"./src/services/api-service.js\");\n\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  name: \"BookCreate\",\n  data: function data() {\n    return {\n      libraryEntities: {},\n      bookTitle: '',\n      selectedAuthor: {},\n      selectedGenre: {}\n    };\n  },\n  mounted: function mounted() {\n    this.loadLibraryEntities();\n  },\n  methods: {\n    loadLibraryEntities: function loadLibraryEntities() {\n      var that = this;\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].getEditLibraryEntities().then(function (response) {\n        console.log(response.data);\n        that.libraryEntities = response.data;\n      });\n    },\n    addBook: function addBook() {\n      var that = this;\n      var bookToAdd = {\n        title: this.bookTitle,\n        author: this.selectedAuthor,\n        genre: this.selectedGenre\n      };\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].addBook(bookToAdd).then(function (response) {\n        that.$emit('bookAdded', response.data);\n      });\n    }\n  }\n});\n\n//# sourceURL=webpack:///./src/components/book/BookAdd.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/BookList.vue?vue&type=script&lang=js":
/*!******************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/BookList.vue?vue&type=script&lang=js ***!
  \******************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _services_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @/services/api-service */ \"./src/services/api-service.js\");\n/* harmony import */ var _components_book_BookAdd_vue__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @/components/book/BookAdd.vue */ \"./src/components/book/BookAdd.vue\");\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  name: \"BookList\",\n  components: {\n    BookAdd: _components_book_BookAdd_vue__WEBPACK_IMPORTED_MODULE_1__[\"default\"]\n  },\n  data: function data() {\n    return {\n      isCreateMode: false,\n      books: {},\n      book: {}\n    };\n  },\n  mounted: function mounted() {\n    this.getBookList();\n  },\n  methods: {\n    getBookList: function getBookList() {\n      var that = this;\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].getBookList().then(function (response) {\n        that.books = response.data;\n      })[\"catch\"](function (error) {//todo: add error message\n      });\n    },\n    createBook: function createBook() {\n      this.isCreateMode = true;\n    },\n    updateBookList: function updateBookList(addedBook) {\n      this.books.push(addedBook);\n      this.isCreateMode = false;\n    },\n    deleteBook: function deleteBook(bookId) {\n      var that = this;\n      _services_api_service__WEBPACK_IMPORTED_MODULE_0__[\"default\"].deleteBook(bookId).then(function () {\n        that.getBookList();\n        that.isBookView = false;\n      });\n    }\n  }\n});\n\n//# sourceURL=webpack:///./src/views/BookList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2":
/*!**********************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2 ***!
  \**********************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return render; });\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! core-js/modules/es.function.name.js */ \"./node_modules/core-js/modules/es.function.name.js\");\n/* harmony import */ var core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(core_js_modules_es_function_name_js__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var vue__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! vue */ \"./node_modules/vue/dist/vue.runtime.esm-bundler.js\");\n\n\nvar _hoisted_1 = {\n  \"class\": \"col-12\"\n};\nvar _hoisted_2 = {\n  \"class\": \"form-group\"\n};\n\nvar _hoisted_3 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"h1\", null, \"Add book\", -1\n/* HOISTED */\n);\n\nvar _hoisted_4 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"label\", {\n  \"for\": \"holder-input\"\n}, \"Title:\", -1\n/* HOISTED */\n);\n\nvar _hoisted_5 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"label\", {\n  \"for\": \"authorSelect\"\n}, \"Choose author:\", -1\n/* HOISTED */\n);\n\nvar _hoisted_6 = [\"value\"];\n\nvar _hoisted_7 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"label\", {\n  \"for\": \"genreSelect\"\n}, \"Choose genre:\", -1\n/* HOISTED */\n);\n\nvar _hoisted_8 = [\"value\"];\nfunction render(_ctx, _cache, $props, $setup, $data, $options) {\n  return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"div\", _hoisted_1, [Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"div\", _hoisted_2, [_hoisted_3, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"div\", null, [_hoisted_4, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"withDirectives\"])(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"input\", {\n    id: \"holder-input\",\n    name: \"title\",\n    type: \"text\",\n    \"onUpdate:modelValue\": _cache[0] || (_cache[0] = function ($event) {\n      return _ctx.bookTitle = $event;\n    })\n  }, null, 512\n  /* NEED_PATCH */\n  ), [[vue__WEBPACK_IMPORTED_MODULE_1__[\"vModelText\"], _ctx.bookTitle]])]), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"div\", null, [_hoisted_5, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"withDirectives\"])(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"select\", {\n    id: \"authorSelect\",\n    \"class\": \"form-control\",\n    \"onUpdate:modelValue\": _cache[1] || (_cache[1] = function ($event) {\n      return _ctx.selectedAuthor = $event;\n    })\n  }, [(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(true), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(vue__WEBPACK_IMPORTED_MODULE_1__[\"Fragment\"], null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"renderList\"])(_ctx.libraryEntities.authors, function (author) {\n    return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"option\", {\n      value: author\n    }, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(author.name), 9\n    /* TEXT, PROPS */\n    , _hoisted_6);\n  }), 256\n  /* UNKEYED_FRAGMENT */\n  ))], 512\n  /* NEED_PATCH */\n  ), [[vue__WEBPACK_IMPORTED_MODULE_1__[\"vModelSelect\"], _ctx.selectedAuthor]])]), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"div\", null, [_hoisted_7, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"withDirectives\"])(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"select\", {\n    id: \"genreSelect\",\n    \"class\": \"form-control\",\n    \"onUpdate:modelValue\": _cache[2] || (_cache[2] = function ($event) {\n      return _ctx.selectedGenre = $event;\n    })\n  }, [(Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(true), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(vue__WEBPACK_IMPORTED_MODULE_1__[\"Fragment\"], null, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"renderList\"])(_ctx.libraryEntities.genres, function (genre) {\n    return Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementBlock\"])(\"option\", {\n      value: genre\n    }, Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"toDisplayString\"])(genre.name), 9\n    /* TEXT, PROPS */\n    , _hoisted_8);\n  }), 256\n  /* UNKEYED_FRAGMENT */\n  ))], 512\n  /* NEED_PATCH */\n  ), [[vue__WEBPACK_IMPORTED_MODULE_1__[\"vModelSelect\"], _ctx.selectedGenre]])]), Object(vue__WEBPACK_IMPORTED_MODULE_1__[\"createElementVNode\"])(\"button\", {\n    \"class\": \"btn btn-primary\",\n    onClick: _cache[3] || (_cache[3] = function ($event) {\n      return $options.addBook();\n    })\n  }, \"Save \")])]);\n}\n\n//# sourceURL=webpack:///./src/components/book/BookAdd.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/BookList.vue?vue&type=template&id=24c12c3e":
/*!*************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1!./src/views/BookList.vue?vue&type=template&id=24c12c3e ***!
  \*************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return render; });\n/* harmony import */ var vue__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! vue */ \"./node_modules/vue/dist/vue.runtime.esm-bundler.js\");\n\nvar _hoisted_1 = {\n  key: 1,\n  \"class\": \"col-12\"\n};\n\nvar _hoisted_2 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"h1\", null, \"Books\", -1\n/* HOISTED */\n);\n\nvar _hoisted_3 = {\n  \"class\": \"table\"\n};\n\nvar _hoisted_4 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"thead\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"tr\", null, [/*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"th\", null, \"ID\"), /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"th\", null, \"Title\"), /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"th\", null, \"Book page\"), /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"th\", null, \"Delete\")])], -1\n/* HOISTED */\n);\n\nvar _hoisted_5 = /*#__PURE__*/Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createTextVNode\"])(\"Info\");\n\nvar _hoisted_6 = [\"onClick\"];\nvar _hoisted_7 = {\n  colspan: \"4\"\n};\nfunction render(_ctx, _cache, $props, $setup, $data, $options) {\n  var _component_book_add = Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"resolveComponent\"])(\"book-add\");\n\n  var _component_router_link = Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"resolveComponent\"])(\"router-link\");\n\n  return _ctx.isCreateMode ? (Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createBlock\"])(_component_book_add, {\n    key: 0,\n    onBookAdded: $options.updateBookList\n  }, null, 8\n  /* PROPS */\n  , [\"onBookAdded\"])) : (Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementBlock\"])(\"div\", _hoisted_1, [_hoisted_2, Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"table\", _hoisted_3, [_hoisted_4, Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"tbody\", null, [(Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"openBlock\"])(true), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementBlock\"])(vue__WEBPACK_IMPORTED_MODULE_0__[\"Fragment\"], null, Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"renderList\"])(_ctx.books, function (book, index) {\n    return Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"openBlock\"])(), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementBlock\"])(\"tr\", {\n      key: index\n    }, [Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"toDisplayString\"])(book.id), 1\n    /* TEXT */\n    ), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"td\", null, Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"toDisplayString\"])(book.title), 1\n    /* TEXT */\n    ), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"td\", null, [Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createVNode\"])(_component_router_link, {\n      to: {\n        name: 'Book page',\n        params: {\n          id: book.id\n        }\n      }\n    }, {\n      \"default\": Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"withCtx\"])(function () {\n        return [_hoisted_5];\n      }),\n      _: 2\n      /* DYNAMIC */\n\n    }, 1032\n    /* PROPS, DYNAMIC_SLOTS */\n    , [\"to\"])]), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"td\", null, [Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"button\", {\n      \"class\": \"btn btn-primary\",\n      onClick: function onClick($event) {\n        return $options.deleteBook(book.id);\n      }\n    }, \"Delete \", 8\n    /* PROPS */\n    , _hoisted_6)])]);\n  }), 128\n  /* KEYED_FRAGMENT */\n  )), Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"tr\", null, [Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"td\", _hoisted_7, [Object(vue__WEBPACK_IMPORTED_MODULE_0__[\"createElementVNode\"])(\"a\", {\n    href: \"#\",\n    onClick: _cache[0] || (_cache[0] = function ($event) {\n      return $options.createBook();\n    })\n  }, \"Add Book\")])])])])]));\n}\n\n//# sourceURL=webpack:///./src/views/BookList.vue?./node_modules/cache-loader/dist/cjs.js??ref--13-0!./node_modules/babel-loader/lib!./node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!./node_modules/cache-loader/dist/cjs.js??ref--1-0!./node_modules/vue-loader-v16/dist??ref--1-1");

/***/ }),

/***/ "./src/components/book/BookAdd.vue":
/*!*****************************************!*\
  !*** ./src/components/book/BookAdd.vue ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _BookAdd_vue_vue_type_template_id_05cbaec2__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./BookAdd.vue?vue&type=template&id=05cbaec2 */ \"./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2\");\n/* harmony import */ var _BookAdd_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./BookAdd.vue?vue&type=script&lang=js */ \"./src/components/book/BookAdd.vue?vue&type=script&lang=js\");\n/* empty/unused harmony star reexport *//* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/vue-loader-v16/dist/exportHelper.js */ \"./node_modules/vue-loader-v16/dist/exportHelper.js\");\n/* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__);\n\n\n\n\n\nconst __exports__ = /*#__PURE__*/D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default()(_BookAdd_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"], [['render',_BookAdd_vue_vue_type_template_id_05cbaec2__WEBPACK_IMPORTED_MODULE_0__[\"render\"]],['__file',\"src/components/book/BookAdd.vue\"]])\n/* hot reload */\nif (false) {}\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = (__exports__);\n\n//# sourceURL=webpack:///./src/components/book/BookAdd.vue?");

/***/ }),

/***/ "./src/components/book/BookAdd.vue?vue&type=script&lang=js":
/*!*****************************************************************!*\
  !*** ./src/components/book/BookAdd.vue?vue&type=script&lang=js ***!
  \*****************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookAdd_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../../node_modules/babel-loader/lib!../../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../../node_modules/vue-loader-v16/dist??ref--1-1!./BookAdd.vue?vue&type=script&lang=js */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/components/book/BookAdd.vue?vue&type=script&lang=js\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"default\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookAdd_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"]; });\n\n/* empty/unused harmony star reexport */ \n\n//# sourceURL=webpack:///./src/components/book/BookAdd.vue?");

/***/ }),

/***/ "./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2":
/*!***********************************************************************!*\
  !*** ./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2 ***!
  \***********************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookAdd_vue_vue_type_template_id_05cbaec2__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../../node_modules/babel-loader/lib!../../../node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!../../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../../node_modules/vue-loader-v16/dist??ref--1-1!./BookAdd.vue?vue&type=template&id=05cbaec2 */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/components/book/BookAdd.vue?vue&type=template&id=05cbaec2\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookAdd_vue_vue_type_template_id_05cbaec2__WEBPACK_IMPORTED_MODULE_0__[\"render\"]; });\n\n\n\n//# sourceURL=webpack:///./src/components/book/BookAdd.vue?");

/***/ }),

/***/ "./src/views/BookList.vue":
/*!********************************!*\
  !*** ./src/views/BookList.vue ***!
  \********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _BookList_vue_vue_type_template_id_24c12c3e__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./BookList.vue?vue&type=template&id=24c12c3e */ \"./src/views/BookList.vue?vue&type=template&id=24c12c3e\");\n/* harmony import */ var _BookList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./BookList.vue?vue&type=script&lang=js */ \"./src/views/BookList.vue?vue&type=script&lang=js\");\n/* empty/unused harmony star reexport *//* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/vue-loader-v16/dist/exportHelper.js */ \"./node_modules/vue-loader-v16/dist/exportHelper.js\");\n/* harmony import */ var D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2__);\n\n\n\n\n\nconst __exports__ = /*#__PURE__*/D_programming_2021_08_otus_spring_Mikheev_frontend_node_modules_vue_loader_v16_dist_exportHelper_js__WEBPACK_IMPORTED_MODULE_2___default()(_BookList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"], [['render',_BookList_vue_vue_type_template_id_24c12c3e__WEBPACK_IMPORTED_MODULE_0__[\"render\"]],['__file',\"src/views/BookList.vue\"]])\n/* hot reload */\nif (false) {}\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = (__exports__);\n\n//# sourceURL=webpack:///./src/views/BookList.vue?");

/***/ }),

/***/ "./src/views/BookList.vue?vue&type=script&lang=js":
/*!********************************************************!*\
  !*** ./src/views/BookList.vue?vue&type=script&lang=js ***!
  \********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./BookList.vue?vue&type=script&lang=js */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/BookList.vue?vue&type=script&lang=js\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"default\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookList_vue_vue_type_script_lang_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"]; });\n\n/* empty/unused harmony star reexport */ \n\n//# sourceURL=webpack:///./src/views/BookList.vue?");

/***/ }),

/***/ "./src/views/BookList.vue?vue&type=template&id=24c12c3e":
/*!**************************************************************!*\
  !*** ./src/views/BookList.vue?vue&type=template&id=24c12c3e ***!
  \**************************************************************/
/*! exports provided: render */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookList_vue_vue_type_template_id_24c12c3e__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--13-0!../../node_modules/babel-loader/lib!../../node_modules/vue-loader-v16/dist/templateLoader.js??ref--6!../../node_modules/cache-loader/dist/cjs.js??ref--1-0!../../node_modules/vue-loader-v16/dist??ref--1-1!./BookList.vue?vue&type=template&id=24c12c3e */ \"./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/vue-loader-v16/dist/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader-v16/dist/index.js?!./src/views/BookList.vue?vue&type=template&id=24c12c3e\");\n/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, \"render\", function() { return _node_modules_cache_loader_dist_cjs_js_ref_13_0_node_modules_babel_loader_lib_index_js_node_modules_vue_loader_v16_dist_templateLoader_js_ref_6_node_modules_cache_loader_dist_cjs_js_ref_1_0_node_modules_vue_loader_v16_dist_index_js_ref_1_1_BookList_vue_vue_type_template_id_24c12c3e__WEBPACK_IMPORTED_MODULE_0__[\"render\"]; });\n\n\n\n//# sourceURL=webpack:///./src/views/BookList.vue?");

/***/ })

}]);