//package com.app.whatsupmessage.resources;
//
//import com.app.whatsupmessage.dto.BlockMenuDto;
//import com.app.whatsupmessage.entity.BlockMenu;
//import com.app.whatsupmessage.response.BlockMenuResponse;
//import com.app.whatsupmessage.service.BlockMenuService;
//import com.app.whatsupmessage.utils.CommonDataHelper;
//import com.app.whatsupmessage.utils.PaginatedResponse;
//import com.app.whatsupmessage.validation.BlockMenuValidator;
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
//
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
//@RequestMapping("api/v1/block-menu")
//@Tag(name = "Block Menu API")
//public class BlockMenuResource {
//
//    private final BlockMenuValidator validator;
//    private final BlockMenuService service;
//    private final String[] sortable = {"id", ""};
//    private final CommonDataHelper commonDataHelper;
//
//
//    @PostMapping("/save")
//    @Operation(summary = "Save block menu", description = "Save block menu")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> saveBlockMenu(@Valid @RequestBody BlockMenuDto dto, BindingResult bindingResult) {
//
//        ValidationUtils.invokeValidator(validator, dto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return badRequest().body(error(fieldError(bindingResult)).getJson());
//        }
//        BlockMenu blockMenu=service.save(dto);
//        return ok(success( BlockMenuResponse.from(blockMenu), BLOCK_MENU_SAVE).getJson());
//    }
//
//    @PostMapping("/update")
//    @Operation(summary = "Save block menu", description = "Save block menu")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> updateBlockMenu(@Valid @RequestBody BlockMenuDto dto, BindingResult bindingResult) {
//        BlockMenu blockMenu=service.update(dto);
//        return ok(success(BlockMenuResponse.from(blockMenu), BLOCK_MENU_UPDATE).getJson());
//    }
//
//    @GetMapping("/find/{id}")
//    @Operation(summary = "Get block menu by ID", description = "Get block menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> findById(@Valid @PathVariable @NotNull Long id) {
//
//        BlockMenu blockMenu = service.findById(id);
//        return ok(success(BlockMenuResponse.from(blockMenu)).getJson());
//    }
//
//
//    @GetMapping("/findAll")
//    @Operation(summary = "Get ALL block menu by ID", description = "Get ALL block menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> findAll() {
//
//        List<BlockMenuResponse> responses = service.findAll()
//                .stream()
//                .map(BlockMenuResponse::from)
//                .collect(Collectors.toList());
//        return ok(success(responses).getJson());
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    @Operation(summary = "Delete  block menu by ID", description = "Delete block menu by ID")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ok(success(null, BLOCK_MENU_DELETE ).getJson());
//    }
//
//
//    @GetMapping("/list")
//    @Operation(summary = "block menu list", description = "block menu list")
//    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
//    public ResponseEntity<JSONObject> getList(
//            @RequestParam(value = "page", defaultValue = "1") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size,
//            @RequestParam(value = "sortBy", defaultValue = "") String sortBy,
//            @RequestParam(value = "blockMenuName", defaultValue = "") String blockMenuName
//    ) {
//        Map<String, Object> blockMenuMap = service.searchBlockMenuList(blockMenuName, page, size, sortBy);
//        PaginatedResponse response = new PaginatedResponse();
//        List<BlockMenu> responses = (List<BlockMenu>) blockMenuMap.get("lists");
//        List<BlockMenuResponse> customResponses = responses.stream()
//                .map(BlockMenuResponse::from)
//                .collect(Collectors.toList());
//        commonDataHelper.getCommonData(page, size, blockMenuMap, response, customResponses);
//        return ok(paginatedSuccess(response).getJson());
//    }
//
//
//}
