//package com.app.whatsupmessage.resources;
//
//import com.app.whatsupmessage.dto.BlockSubMenuDto;
//import com.app.whatsupmessage.entity.BlockSubMenu;
//import com.app.whatsupmessage.enums.BlockTypeStatus;
//import com.app.whatsupmessage.response.BlockSubMenuResponse;
//import com.app.whatsupmessage.service.BlockSubMenuService;
//import com.app.whatsupmessage.utils.CommonDataHelper;
//import com.app.whatsupmessage.utils.PaginatedResponse;
//import com.app.whatsupmessage.validation.BlockSubMenuValidator;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.json.simple.JSONObject;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static com.app.whatsupmessage.constant.MessageConstants.*;
//import static com.app.whatsupmessage.exception.ApiError.fieldError;
//import static com.app.whatsupmessage.utils.ResponseBuilder.*;
//import static org.springframework.http.ResponseEntity.badRequest;
//import static org.springframework.http.ResponseEntity.ok;
//
//@Validated
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/block-sub-menu")
//@Tag(name = "Block Submenu API")
//public class BlockSubMenuResource {
//
//    private final BlockSubMenuValidator validator;
//    private final BlockSubMenuService service;
//    private final String[] sortable = {"id", ""};
//    private final CommonDataHelper commonDataHelper;
//
//
//    @PostMapping("/save")
//    @Operation(summary = "Save block submenu", description = "Save block sub menu")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> saveBlockSubMenu(@Valid @RequestBody BlockSubMenuDto dto, BindingResult bindingResult) {
//
//        ValidationUtils.invokeValidator(validator, dto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return badRequest().body(error(fieldError(bindingResult)).getJson());
//        }
//        BlockSubMenu subMenu=service.save(dto);
//        return ok(success( BlockSubMenuResponse.from(subMenu), BLOCK_SUBMENU_SAVE).getJson());
//    }
//
//    @PostMapping("/update")
//    @Operation(summary = "Update block SUB menu", description = "Save block sub menu")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> updateBlockMenu(@Valid @RequestBody BlockSubMenuDto dto, BindingResult bindingResult) {
//        BlockSubMenu subMenu=service.update(dto);
//        return ok(success(BlockSubMenuResponse.from(subMenu), BLOCK_SUBMENU_UPDATE).getJson());
//    }
//
//    @GetMapping("/find/{id}")
//    @Operation(summary = "Get block sub menu by ID", description = "Get block sub menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> findById(@Valid @PathVariable @NotNull Long id) {
//
//        BlockSubMenu subMenu = service.findById(id);
//        return ok(success(BlockSubMenuResponse.from(subMenu)).getJson());
//    }
//
//
//    @GetMapping("/findAll")
//    @Operation(summary = "Get ALL block menu by ID", description = "Get ALL block menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> findAll() {
//
//        List<BlockSubMenuResponse> responses = service.findAll()
//                .stream()
//                .map(BlockSubMenuResponse::from)
//                .collect(Collectors.toList());
//        return ok(success(responses).getJson());
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    @Operation(summary = "Delete  block sub menu by ID", description = "Delete block menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ok(success(null, BLOCK_SUBMENU_DELETE ).getJson());
//    }
//
//
//    @GetMapping("/list")
//    @Operation(summary = "block sub menu list", description = "block sub menu list")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> getList(
//            @RequestParam(value = "page", defaultValue = "1") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size,
//            @RequestParam(value = "sortBy", defaultValue = "") String sortBy,
//            @RequestParam(value = "blockSubMenuName", defaultValue = "") String blockSubMenuName,
//            @RequestParam(value = "blockMenuId", defaultValue = "") Long blockMenuId,
//            @RequestParam(value = "blockTypeStatus", defaultValue = "") BlockTypeStatus blockTypeStatus
//
//    ) {
//        Map<String, Object> subMenuMap = service.searchBlockSubMenuList(blockSubMenuName,blockMenuId,blockTypeStatus, page, size, sortBy);
//        PaginatedResponse response = new PaginatedResponse();
//        List<BlockSubMenu> responses = (List<BlockSubMenu>) subMenuMap.get("lists");
//        List<BlockSubMenuResponse> customResponses = responses.stream()
//                .map(BlockSubMenuResponse::from)
//                .collect(Collectors.toList());
//        commonDataHelper.getCommonData(page, size, subMenuMap, response, customResponses);
//        return ok(paginatedSuccess(response).getJson());
//    }
//
//
//}
