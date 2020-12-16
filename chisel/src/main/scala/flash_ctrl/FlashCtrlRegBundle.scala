// SPDX-FileCopyrightText: 2020 Muhammad Hadir Khan
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// SPDX-License-Identifier: Apache-2.0
package flash_ctrl
import chisel3._

class FlashCtrlReg2Hw extends Bundle {
  val intr_state = new Bundle {
    val rd_full = new Bundle {
      val q = Output(Bool())
    }
    val op_done = new Bundle {
      val q = Output(Bool())
    }
    val op_error = new Bundle {
      val q = Output(Bool())
    }
  }

  val intr_enable = new Bundle {
    val rd_full = new Bundle {
      val q = Output(Bool())
    }
    val op_done = new Bundle {
      val q = Output(Bool())
    }
    val op_error = new Bundle {
      val q = Output(Bool())
    }
  }

  val intr_test = new Bundle {
    val rd_full = new Bundle {
      val q = Output(Bool())
      val qe = Output(Bool())
    }
    val op_done = new Bundle {
      val q = Output(Bool())
      val qe = Output(Bool())
    }
    val op_error = new Bundle {
      val q = Output(Bool())
      val qe = Output(Bool())
    }
  }

  val control = new Bundle {
    val start = new Bundle {
      val q = Output(Bool())
    }
    val op = new Bundle {
      val q = Output(UInt(2.W))
    }
    val prog_sel = new Bundle {
      val q = Output(Bool())
    }
    val num = new Bundle {
      val q = Output(UInt(12.W))
    }
  }

  val addr = new Bundle {
    val q = Output(UInt(32.W))
  }

  val fifo_rst = new Bundle {
    val q = Output(Bool())
  }
}

class FlashCtrlHw2Reg extends Bundle {
  val intr_state = new Bundle {
    val rd_full = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val op_done = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val op_error = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
  }

  val ctrl_regwen = new Bundle {
    val d = Input(Bool())
  }

  val control = new Bundle {
    val start = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
  }

  val op_status = new Bundle {
    val done = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val err = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
  }

  val status = new Bundle {
    val rd_full = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val rd_empty = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val init_wip = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
    val error_addr = new Bundle {
      val d = Input(UInt(9.W))
      val de = Input(Bool())
    }
  }

  val phy_status = new Bundle {
    val init_wip = new Bundle {
      val d = Input(Bool())
      val de = Input(Bool())
    }
  }
}
