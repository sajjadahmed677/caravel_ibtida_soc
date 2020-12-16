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
package primitives
import chisel3._
import scala.collection.script.Reset
import chisel3.util.experimental.loadMemoryFromFile

class InstMem extends Module {
  val io = IO(new Bundle{
    val en_i = Input(Bool())   // active high memory enable
    val we_i = Input(Vec(4,Bool()))    // active high write enable with masking
    val addr_i = Input(UInt(6.W))
    val wdata_i = Input(UInt(32.W))
    val rdata_o = Output(UInt(32.W))
  })

  val mem = SyncReadMem(64, UInt(32.W))

//  loadMemoryFromFile(mem,"/home/merl/Desktop/mem.txt")
//
//  io.instr_rdata_o := mem.read(io.instr_addr_i)

  when(io.en_i) {
    io.rdata_o := mem.read(io.addr_i)
    when(io.we_i.forall(p => p === true.B)) {   // when all we_i are true only then write, since we do not support masking in instruction memory but dffram requires it.
      mem.write(io.addr_i, io.wdata_i)
    }
  } .otherwise {
    io.rdata_o := DontCare
  }


//  when(!io.en_i && !io.we_i) {
//    mem.write(io.addr_i, io.wdata_i)
//    io.rdata_o := DontCare
//  } .elsewhen(!io.en_i && io.we_i) {
//    io.rdata_o := mem.read(io.addr_i)
//  } .otherwise {
//    io.rdata_o := DontCare
//  }
  
}
