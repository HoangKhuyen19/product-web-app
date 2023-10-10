<!DOCTYPE html>
<html>

<head>
    <title>Xác nhận xoá sản phẩm</title>
</head>

<body>

    <button onclick="hienThiXacNhan()">Xoá sản phẩm</button>

    <script>
        function hienThiXacNhan() {
            // Sử dụng hàm `window.confirm()` để hiển thị hộp thoại xác nhận
            var xacNhan = window.confirm("Bạn có muốn xoá sản phẩm này không?");
            if (xacNhan) {
                // Người dùng đã xác nhận, thực hiện hành động xoá ở đây
                alert("Sản phẩm đã được xoá!");
            } else {
                // Người dùng đã từ chối, không thực hiện hành động xoá
                alert("Xoá sản phẩm đã bị hủy!");
            }
        }
    </script>
</body>

</html>