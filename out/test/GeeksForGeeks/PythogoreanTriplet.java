import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PythogoreanTriplet {
    static boolean isSquare(long i){
        return Math.floor(Math.sqrt(i)) == Math.ceil(Math.sqrt(i)) ;
    }

    static int dp[][] = {{3, 4, 5},
            {5, 12, 13},
            {6, 8, 10},
            {7, 24, 25},
            {8, 15, 17},
            {9, 12, 15},
            {9, 40, 41},
            {10, 24, 26},
            {11, 60, 61},
            {12, 16, 20},
            {12, 35, 37},
            {13, 84, 85},
            {14, 48, 50},
            {15, 20, 25},
            {15, 36, 39},
            {15, 112, 113},
            {16, 30, 34},
            {16, 63, 65},
            {17, 144, 145},
            {18, 24, 30},
            {18, 80, 82},
            {19, 180, 181},
            {20, 21, 29},
            {20, 48, 52},
            {20, 99, 101},
            {21, 28, 35},
            {21, 72, 75},
            {21, 220, 221},
            {22, 120, 122},
            {23, 264, 265},
            {24, 32, 40},
            {24, 45, 51},
            {24, 70, 74},
            {24, 143, 145},
            {25, 60, 65},
            {25, 312, 313},
            {26, 168, 170},
            {27, 36, 45},
            {27, 120, 123},
            {27, 364, 365},
            {28, 45, 53},
            {28, 96, 100},
            {28, 195, 197},
            {29, 420, 421},
            {30, 40, 50},
            {30, 72, 78},
            {30, 224, 226},
            {31, 480, 481},
            {32, 60, 68},
            {32, 126, 130},
            {32, 255, 257},
            {33, 44, 55},
            {33, 56, 65},
            {33, 180, 183},
            {33, 544, 545},
            {34, 288, 290},
            {35, 84, 91},
            {35, 120, 125},
            {35, 612, 613},
            {36, 48, 60},
            {36, 77, 85},
            {36, 105, 111},
            {36, 160, 164},
            {36, 323, 325},
            {37, 684, 685},
            {38, 360, 362},
            {39, 52, 65},
            {39, 80, 89},
            {39, 252, 255},
            {39, 760, 761},
            {40, 42, 58},
            {40, 75, 85},
            {40, 96, 104},
            {40, 198, 202},
            {40, 399, 401},
            {41, 840, 841},
            {42, 56, 70},
            {42, 144, 150},
            {42, 440, 442},
            {43, 924, 925},
            {44, 117, 125},
            {44, 240, 244},
            {44, 483, 485},
            {45, 60, 75},
            {45, 108, 117},
            {45, 200, 205},
            {45, 336, 339},
            {46, 528, 530},
            {48, 55, 73},
            {48, 64, 80},
            {48, 90, 102},
            {48, 140, 148},
            {48, 189, 195},
            {48, 286, 290},
            {48, 575, 577},
            {49, 168, 175},
            {50, 120, 130},
            {50, 624, 626},
            {51, 68, 85},
            {51, 140, 149},
            {51, 432, 435},
            {52, 165, 173},
            {52, 336, 340},
            {52, 675, 677},
            {54, 72, 90},
            {54, 240, 246},
            {54, 728, 730},
            {55, 132, 143},
            {55, 300, 305},
            {56, 90, 106},
            {56, 105, 119},
            {56, 192, 200},
            {56, 390, 394},
            {56, 783, 785},
            {57, 76, 95},
            {57, 176, 185},
            {57, 540, 543},
            {58, 840, 842},
            {60, 63, 87},
            {60, 80, 100},
            {60, 91, 109},
            {60, 144, 156},
            {60, 175, 185},
            {60, 221, 229},
            {60, 297, 303},
            {60, 448, 452},
            {60, 899, 901},
            {62, 960, 962},
            {63, 84, 105},
            {63, 216, 225},
            {63, 280, 287},
            {63, 660, 663},
            {64, 120, 136},
            {64, 252, 260},
            {64, 510, 514},
            {65, 72, 97},
            {65, 156, 169},
            {65, 420, 425},
            {66, 88, 110},
            {66, 112, 130},
            {66, 360, 366},
            {68, 285, 293},
            {68, 576, 580},
            {69, 92, 115},
            {69, 260, 269},
            {69, 792, 795},
            {70, 168, 182},
            {70, 240, 250},
            {72, 96, 120},
            {72, 135, 153},
            {72, 154, 170},
            {72, 210, 222},
            {72, 320, 328},
            {72, 429, 435},
            {72, 646, 650},
            {75, 100, 125},
            {75, 180, 195},
            {75, 308, 317},
            {75, 560, 565},
            {75, 936, 939},
            {76, 357, 365},
            {76, 720, 724},
            {77, 264, 275},
            {77, 420, 427},
            {78, 104, 130},
            {78, 160, 178},
            {78, 504, 510},
            {80, 84, 116},
            {80, 150, 170},
            {80, 192, 208},
            {80, 315, 325},
            {80, 396, 404},
            {80, 798, 802},
            {81, 108, 135},
            {81, 360, 369},
            {84, 112, 140},
            {84, 135, 159},
            {84, 187, 205},
            {84, 245, 259},
            {84, 288, 300},
            {84, 437, 445},
            {84, 585, 591},
            {84, 880, 884},
            {85, 132, 157},
            {85, 204, 221},
            {85, 720, 725},
            {87, 116, 145},
            {87, 416, 425},
            {88, 105, 137},
            {88, 165, 187},
            {88, 234, 250},
            {88, 480, 488},
            {88, 966, 970},
            {90, 120, 150},
            {90, 216, 234},
            {90, 400, 410},
            {90, 672, 678},
            {91, 312, 325},
            {91, 588, 595},
            {92, 525, 533},
            {93, 124, 155},
            {93, 476, 485},
            {95, 168, 193},
            {95, 228, 247},
            {95, 900, 905},
            {96, 110, 146},
            {96, 128, 160},
            {96, 180, 204},
            {96, 247, 265},
            {96, 280, 296},
            {96, 378, 390},
            {96, 572, 580},
            {96, 765, 771},
            {98, 336, 350},
            {99, 132, 165},
            {99, 168, 195},
            {99, 440, 451},
            {99, 540, 549},
            {100, 105, 145},
            {100, 240, 260},
            {100, 495, 505},
            {100, 621, 629},
            {102, 136, 170},
            {102, 280, 298},
            {102, 864, 870},
            {104, 153, 185},
            {104, 195, 221},
            {104, 330, 346},
            {104, 672, 680},
            {105, 140, 175},
            {105, 208, 233},
            {105, 252, 273},
            {105, 360, 375},
            {105, 608, 617},
            {105, 784, 791},
            {108, 144, 180},
            {108, 231, 255},
            {108, 315, 333},
            {108, 480, 492},
            {108, 725, 733},
            {108, 969, 975},
            {110, 264, 286},
            {110, 600, 610},
            {111, 148, 185},
            {111, 680, 689},
            {112, 180, 212},
            {112, 210, 238},
            {112, 384, 400},
            {112, 441, 455},
            {112, 780, 788},
            {114, 152, 190},
            {114, 352, 370},
            {115, 252, 277},
            {115, 276, 299},
            {116, 837, 845},
            {117, 156, 195},
            {117, 240, 267},
            {117, 520, 533},
            {117, 756, 765},
            {119, 120, 169},
            {119, 408, 425},
            {120, 126, 174},
            {120, 160, 200},
            {120, 182, 218},
            {120, 209, 241},
            {120, 225, 255},
            {120, 288, 312},
            {120, 350, 370},
            {120, 391, 409},
            {120, 442, 458},
            {120, 594, 606},
            {120, 715, 725},
            {120, 896, 904},
            {121, 660, 671},
            {123, 164, 205},
            {123, 836, 845},
            {124, 957, 965},
            {125, 300, 325},
            {126, 168, 210},
            {126, 432, 450},
            {126, 560, 574},
            {128, 240, 272},
            {128, 504, 520},
            {129, 172, 215},
            {129, 920, 929},
            {130, 144, 194},
            {130, 312, 338},
            {130, 840, 850},
            {132, 176, 220},
            {132, 224, 260},
            {132, 351, 375},
            {132, 385, 407},
            {132, 475, 493},
            {132, 720, 732},
            {133, 156, 205},
            {133, 456, 475},
            {135, 180, 225},
            {135, 324, 351},
            {135, 352, 377},
            {135, 600, 615},
            {136, 255, 289},
            {136, 273, 305},
            {136, 570, 586},
            {138, 184, 230},
            {138, 520, 538},
            {140, 147, 203},
            {140, 171, 221},
            {140, 225, 265},
            {140, 336, 364},
            {140, 480, 500},
            {140, 693, 707},
            {140, 975, 985},
            {141, 188, 235},
            {143, 780, 793},
            {143, 924, 935},
            {144, 165, 219},
            {144, 192, 240},
            {144, 270, 306},
            {144, 308, 340},
            {144, 420, 444},
            {144, 567, 585},
            {144, 640, 656},
            {144, 858, 870},
            {145, 348, 377},
            {145, 408, 433},
            {147, 196, 245},
            {147, 504, 525},
            {150, 200, 250},
            {150, 360, 390},
            {150, 616, 634},
            {152, 285, 323},
            {152, 345, 377},
            {152, 714, 730},
            {153, 204, 255},
            {153, 420, 447},
            {153, 680, 697},
            {154, 528, 550},
            {154, 840, 854},
            {155, 372, 403},
            {155, 468, 493},
            {156, 208, 260},
            {156, 320, 356},
            {156, 455, 481},
            {156, 495, 519},
            {156, 667, 685},
            {159, 212, 265},
            {160, 168, 232},
            {160, 231, 281},
            {160, 300, 340},
            {160, 384, 416},
            {160, 630, 650},
            {160, 792, 808},
            {161, 240, 289},
            {161, 552, 575},
            {162, 216, 270},
            {162, 720, 738},
            {165, 220, 275},
            {165, 280, 325},
            {165, 396, 429},
            {165, 532, 557},
            {165, 900, 915},
            {168, 224, 280},
            {168, 270, 318},
            {168, 315, 357},
            {168, 374, 410},
            {168, 425, 457},
            {168, 490, 518},
            {168, 576, 600},
            {168, 775, 793},
            {168, 874, 890},
            {170, 264, 314},
            {170, 408, 442},
            {171, 228, 285},
            {171, 528, 555},
            {171, 760, 779},
            {174, 232, 290},
            {174, 832, 850},
            {175, 288, 337},
            {175, 420, 455},
            {175, 600, 625},
            {176, 210, 274},
            {176, 330, 374},
            {176, 468, 500},
            {176, 693, 715},
            {176, 960, 976},
            {177, 236, 295},
            {180, 189, 261},
            {180, 240, 300},
            {180, 273, 327},
            {180, 299, 349},
            {180, 385, 425},
            {180, 432, 468},
            {180, 525, 555},
            {180, 663, 687},
            {180, 800, 820},
            {180, 891, 909},
            {182, 624, 650},
            {183, 244, 305},
            {184, 345, 391},
            {184, 513, 545},
            {185, 444, 481},
            {185, 672, 697},
            {186, 248, 310},
            {186, 952, 970},
            {189, 252, 315},
            {189, 340, 389},
            {189, 648, 675},
            {189, 840, 861},
            {190, 336, 386},
            {190, 456, 494},
            {192, 220, 292},
            {192, 256, 320},
            {192, 360, 408},
            {192, 494, 530},
            {192, 560, 592},
            {192, 756, 780},
            {195, 216, 291},
            {195, 260, 325},
            {195, 400, 445},
            {195, 468, 507},
            {195, 748, 773},
            {196, 315, 371},
            {196, 672, 700},
            {198, 264, 330},
            {198, 336, 390},
            {198, 880, 902},
            {200, 210, 290},
            {200, 375, 425},
            {200, 480, 520},
            {200, 609, 641},
            {201, 268, 335},
            {203, 396, 445},
            {203, 696, 725},
            {204, 253, 325},
            {204, 272, 340},
            {204, 560, 596},
            {204, 595, 629},
            {204, 855, 879},
            {205, 492, 533},
            {205, 828, 853},
            {207, 224, 305},
            {207, 276, 345},
            {207, 780, 807},
            {207, 920, 943},
            {208, 306, 370},
            {208, 390, 442},
            {208, 660, 692},
            {208, 819, 845},
            {210, 280, 350},
            {210, 416, 466},
            {210, 504, 546},
            {210, 720, 750},
            {213, 284, 355},
            {215, 516, 559},
            {215, 912, 937},
            {216, 288, 360},
            {216, 405, 459},
            {216, 462, 510},
            {216, 630, 666},
            {216, 713, 745},
            {216, 960, 984},
            {217, 456, 505},
            {217, 744, 775},
            {219, 292, 365},
            {220, 231, 319},
            {220, 459, 509},
            {220, 528, 572},
            {220, 585, 625},
            {222, 296, 370},
            {224, 360, 424},
            {224, 420, 476},
            {224, 768, 800},
            {224, 882, 910},
            {225, 272, 353},
            {225, 300, 375},
            {225, 540, 585},
            {225, 924, 951},
            {228, 304, 380},
            {228, 325, 397},
            {228, 665, 703},
            {228, 704, 740},
            {230, 504, 554},
            {230, 552, 598},
            {231, 308, 385},
            {231, 392, 455},
            {231, 520, 569},
            {231, 792, 825},
            {232, 435, 493},
            {232, 825, 857},
            {234, 312, 390},
            {234, 480, 534},
            {235, 564, 611},
            {237, 316, 395},
            {238, 240, 338},
            {238, 816, 850},
            {240, 252, 348},
            {240, 275, 365},
            {240, 320, 400},
            {240, 364, 436},
            {240, 418, 482},
            {240, 450, 510},
            {240, 551, 601},
            {240, 576, 624},
            {240, 700, 740},
            {240, 782, 818},
            {240, 884, 916},
            {240, 945, 975},
            {243, 324, 405},
            {245, 588, 637},
            {245, 840, 875},
            {246, 328, 410},
            {248, 465, 527},
            {248, 945, 977},
            {249, 332, 415},
            {250, 600, 650},
            {252, 275, 373},
            {252, 336, 420},
            {252, 405, 477},
            {252, 539, 595},
            {252, 561, 615},
            {252, 735, 777},
            {252, 864, 900},
            {255, 340, 425},
            {255, 396, 471},
            {255, 612, 663},
            {255, 700, 745},
            {256, 480, 544},
            {258, 344, 430},
            {259, 660, 709},
            {259, 888, 925},
            {260, 273, 377},
            {260, 288, 388},
            {260, 624, 676},
            {260, 651, 701},
            {260, 825, 865},
            {261, 348, 435},
            {261, 380, 461},
            {264, 315, 411},
            {264, 352, 440},
            {264, 448, 520},
            {264, 495, 561},
            {264, 702, 750},
            {264, 770, 814},
            {264, 950, 986},
            {265, 636, 689},
            {266, 312, 410},
            {266, 912, 950},
            {267, 356, 445},
            {270, 360, 450},
            {270, 648, 702},
            {270, 704, 754},
            {272, 510, 578},
            {272, 546, 610},
            {273, 364, 455},
            {273, 560, 623},
            {273, 736, 785},
            {273, 936, 975},
            {275, 660, 715},
            {276, 368, 460},
            {276, 493, 565},
            {276, 805, 851},
            {279, 372, 465},
            {279, 440, 521},
            {280, 294, 406},
            {280, 342, 442},
            {280, 351, 449},
            {280, 450, 530},
            {280, 525, 595},
            {280, 672, 728},
            {280, 759, 809},
            {280, 960, 1000},
            {282, 376, 470},
            {285, 380, 475},
            {285, 504, 579},
            {285, 684, 741},
            {285, 880, 925},
            {287, 816, 865},
            {288, 330, 438},
            {288, 384, 480},
            {288, 540, 612},
            {288, 616, 680},
            {288, 741, 795},
            {288, 840, 888},
            {290, 696, 754},
            {290, 816, 866},
            {291, 388, 485},
            {294, 392, 490},
            {295, 708, 767},
            {296, 555, 629},
            {297, 304, 425},
            {297, 396, 495},
            {297, 504, 585},
            {300, 315, 435},
            {300, 400, 500},
            {300, 455, 545},
            {300, 589, 661},
            {300, 720, 780},
            {300, 875, 925},
            {301, 900, 949},
            {303, 404, 505},
            {304, 570, 646},
            {304, 690, 754},
            {305, 732, 793},
            {306, 408, 510},
            {306, 840, 894},
            {308, 435, 533},
            {308, 495, 583},
            {308, 819, 875},
            {309, 412, 515},
            {310, 744, 806},
            {310, 936, 986},
            {312, 416, 520},
            {312, 459, 555},
            {312, 585, 663},
            {312, 640, 712},
            {312, 910, 962},
            {315, 420, 525},
            {315, 572, 653},
            {315, 624, 699},
            {315, 756, 819},
            {318, 424, 530},
            {319, 360, 481},
            {320, 336, 464},
            {320, 462, 562},
            {320, 600, 680},
            {320, 768, 832},
            {321, 428, 535},
            {322, 480, 578},
            {324, 432, 540},
            {324, 693, 765},
            {324, 945, 999},
            {325, 360, 485},
            {325, 780, 845},
            {327, 436, 545},
            {328, 615, 697},
            {330, 440, 550},
            {330, 560, 650},
            {330, 792, 858},
            {333, 444, 555},
            {333, 644, 725},
            {335, 804, 871},
            {336, 377, 505},
            {336, 385, 511},
            {336, 448, 560},
            {336, 527, 625},
            {336, 540, 636},
            {336, 630, 714},
            {336, 748, 820},
            {336, 850, 914},
            {339, 452, 565},
            {340, 357, 493},
            {340, 528, 628},
            {340, 816, 884},
            {341, 420, 541},
            {342, 456, 570},
            {344, 645, 731},
            {345, 460, 575},
            {345, 756, 831},
            {345, 828, 897},
            {348, 464, 580},
            {348, 805, 877},
            {350, 576, 674},
            {350, 840, 910},
            {351, 468, 585},
            {351, 720, 801},
            {352, 420, 548},
            {352, 660, 748},
            {352, 936, 1000},
            {354, 472, 590},
            {355, 852, 923},
            {357, 360, 507},
            {357, 476, 595},
            {360, 378, 522},
            {360, 480, 600},
            {360, 546, 654},
            {360, 598, 698},
            {360, 627, 723},
            {360, 675, 765},
            {360, 770, 850},
            {360, 864, 936},
            {363, 484, 605},
            {363, 616, 715},
            {364, 585, 689},
            {364, 627, 725},
            {365, 876, 949},
            {366, 488, 610},
            {368, 465, 593},
            {368, 690, 782},
            {369, 492, 615},
            {369, 800, 881},
            {370, 888, 962},
            {372, 496, 620},
            {372, 925, 997},
            {375, 500, 625},
            {375, 900, 975},
            {376, 705, 799},
            {378, 504, 630},
            {378, 680, 778},
            {380, 399, 551},
            {380, 672, 772},
            {380, 912, 988},
            {381, 508, 635},
            {384, 440, 584},
            {384, 512, 640},
            {384, 720, 816},
            {385, 552, 673},
            {387, 516, 645},
            {387, 884, 965},
            {390, 432, 582},
            {390, 520, 650},
            {390, 800, 890},
            {392, 630, 742},
            {392, 735, 833},
            {393, 524, 655},
            {396, 403, 565},
            {396, 528, 660},
            {396, 672, 780},
            {396, 847, 935},
            {399, 468, 615},
            {399, 532, 665},
            {400, 420, 580},
            {400, 561, 689},
            {400, 750, 850},
            {402, 536, 670},
            {405, 540, 675},
            {406, 792, 890},
            {407, 624, 745},
            {408, 506, 650},
            {408, 544, 680},
            {408, 765, 867},
            {408, 819, 915},
            {411, 548, 685},
            {414, 448, 610},
            {414, 552, 690},
            {416, 612, 740},
            {416, 780, 884},
            {417, 556, 695},
            {420, 441, 609},
            {420, 513, 663},
            {420, 560, 700},
            {420, 637, 763},
            {420, 675, 795},
            {420, 832, 932},
            {420, 851, 949},
            {423, 564, 705},
            {424, 795, 901},
            {425, 660, 785},
            {426, 568, 710},
            {429, 460, 629},
            {429, 572, 715},
            {429, 700, 821},
            {429, 728, 845},
            {429, 880, 979},
            {432, 495, 657},
            {432, 576, 720},
            {432, 665, 793},
            {432, 810, 918},
            {435, 580, 725},
            {438, 584, 730},
            {440, 462, 638},
            {440, 525, 685},
            {440, 825, 935},
            {441, 588, 735},
            {444, 592, 740},
            {447, 596, 745},
            {448, 720, 848},
            {448, 840, 952},
            {450, 544, 706},
            {450, 600, 750},
            {451, 780, 901},
            {453, 604, 755},
            {455, 504, 679},
            {455, 528, 697},
            {456, 608, 760},
            {456, 650, 794},
            {456, 855, 969},
            {459, 612, 765},
            {460, 483, 667},
            {462, 616, 770},
            {462, 784, 910},
            {464, 777, 905},
            {464, 870, 986},
            {465, 620, 775},
            {468, 595, 757},
            {468, 624, 780},
            {471, 628, 785},
            {473, 864, 985},
            {474, 632, 790},
            {475, 840, 965},
            {476, 480, 676},
            {476, 765, 901},
            {477, 636, 795},
            {480, 504, 696},
            {480, 550, 730},
            {480, 640, 800},
            {480, 693, 843},
            {480, 728, 872},
            {480, 836, 964},
            {481, 600, 769},
            {483, 644, 805},
            {483, 720, 867},
            {486, 648, 810},
            {489, 652, 815},
            {492, 656, 820},
            {495, 660, 825},
            {495, 840, 975},
            {498, 664, 830},
            {500, 525, 725},
            {501, 668, 835},
            {504, 550, 746},
            {504, 672, 840},
            {504, 703, 865},
            {504, 810, 954},
            {507, 676, 845},
            {510, 680, 850},
            {510, 792, 942},
            {513, 684, 855},
            {516, 688, 860},
            {519, 692, 865},
            {520, 546, 754},
            {520, 576, 776},
            {520, 765, 925},
            {522, 696, 870},
            {522, 760, 922},
            {525, 700, 875},
            {528, 605, 803},
            {528, 630, 822},
            {528, 704, 880},
            {531, 708, 885},
            {532, 624, 820},
            {533, 756, 925},
            {534, 712, 890},
            {537, 716, 895},
            {540, 567, 783},
            {540, 629, 829},
            {540, 720, 900},
            {540, 819, 981},
            {543, 724, 905},
            {546, 728, 910},
            {549, 732, 915},
            {552, 736, 920},
            {555, 572, 797},
            {555, 740, 925},
            {558, 744, 930},
            {560, 588, 812},
            {560, 684, 884},
            {560, 702, 898},
            {561, 748, 935},
            {564, 752, 940},
            {567, 756, 945},
            {570, 760, 950},
            {573, 764, 955},
            {576, 660, 876},
            {576, 768, 960},
            {579, 772, 965},
            {580, 609, 841},
            {580, 741, 941},
            {582, 776, 970},
            {585, 648, 873},
            {585, 780, 975},
            {588, 784, 980},
            {591, 788, 985},
            {594, 608, 850},
            {594, 792, 990},
            {595, 600, 845},
            {597, 796, 995},
            {600, 630, 870},
            {600, 800, 1000},
            {612, 759, 975},
            {615, 728, 953},
            {616, 663, 905},
            {616, 735, 959},
            {620, 651, 899},
            {621, 672, 915},
            {624, 715, 949},
            {638, 720, 962},
            {640, 672, 928},
            {650, 720, 970},
            {660, 693, 957},
            {680, 714, 986},
            {696, 697, 985}};

    public static void main(String[] args)throws IOException {
//        for (int i=1;i<=1000;++i){
//            for (int j=i;j<=1000;++j){
//                long sum = (i*i) + (j*j);
//                if(isSquare(sum) && sum<=1000000){
//                    System.out.println("{" + i + ", " + j + ", " + (int)Math.sqrt(sum) + "}, ");
//                }
//            }
//        }

        Stack<Integer>s = new Stack<>();
        s.push(1);
        if (!s.empty()){
            System.out.println(s.peek());
        }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int test = Integer.parseInt(br.readLine());
//        while (test-- > 0){
//            int n = Integer.parseInt(br.readLine());
//            String in[] = br.readLine().trim().split(" ");
//            int a[] = new int[n];
//            Map<Integer,Boolean> hash = new HashMap<>();
//            for (int i=0;i<n;++i){
//                a[i] = Integer.parseInt(in[i]);
//                hash.put(a[i], true);
//            }
//            boolean flag = false;
//            for (int i=0;i<dp.length;++i){
//                if (hash.containsKey(dp[i][0]) && hash.containsKey(dp[i][1]) && hash.containsKey(dp[i][2])){
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag){
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//        }
    }
}
