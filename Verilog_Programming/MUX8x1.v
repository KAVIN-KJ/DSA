module MUX8x1 (
    input wire [2:0]select,
    input wire [7:0]ip,
    output reg y
);

    always @(ip or select) begin
        case (select)
            3'b000: y = ip[0]; 
            3'b001: y = ip[1]; 
            3'b010: y = ip[2]; 
            3'b011: y = ip[3]; 
            3'b100: y = ip[4]; 
            3'b101: y = ip[5]; 
            3'b110: y = ip[6]; 
            3'b111: y = ip[7]; 
        endcase
    end

endmodule

module MUX8x1_TB;

    reg [2:0] sel;
    reg [7:0]in;
    wire y;

    MUX8x1 uut(.select(sel),.ip(in),.y(y));

    initial begin
        in = 8'b10101010; #10;
        sel = 3'b000; #10;
        sel = 3'b001; #10;
        sel = 3'b010; #10;
        sel = 3'b011; #10;
        sel = 3'b100; #10;
        sel = 3'b101; #10;
        sel = 3'b110; #10;
        sel = 3'b111; #10;

    end
    
    initial begin
        $display("Input = %b",in);
        $monitor("Select Line = %b Output = %b",sel,y);
    end

endmodule